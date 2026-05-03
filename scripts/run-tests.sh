#!/usr/bin/env bash
set -euo pipefail

ROOT="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
ANTLR_JAR="${ANTLR_JAR:-/usr/local/lib/antlr-4.13.2-complete.jar}"
JAVA_CP="${JAVA_CP:-$ANTLR_JAR:$ROOT/src}"

TESTS=(
	test1
	test2
	test_print
	test_vars
	test_myclass_twice
	test_bool_print
)

passed=0
failed=0

echo "classpath: $JAVA_CP"
echo

for name in "${TESTS[@]}"; do
	pas="$ROOT/test/${name}.pas"
	exp="$ROOT/test/expected/${name}.expected"
	if [[ ! -f "$pas" ]]; then
		echo "SKIP (missing): $pas" >&2
		((++failed))
		continue
	fi
	if [[ ! -f "$exp" ]]; then
		echo "SKIP (missing): $exp" >&2
		((++failed))
		continue
	fi

	tmp="$(mktemp)"
	set +e
	java -cp "$JAVA_CP" Main "$pas" >"$tmp" 2>"${tmp}.err"
	jcode=$?
	set -e
	if [[ $jcode -ne 0 ]]; then
		echo "FAIL $name: java exit $jcode"
		if [[ -s "${tmp}.err" ]]; then
			echo "--- stderr ---"
			cat "${tmp}.err"
		fi
		((++failed)) || true
		rm -f "$tmp" "${tmp}.err"
		continue
	fi
	if diff -u "$exp" "$tmp" >/dev/null; then
		echo "PASS $name"
		((++passed)) || true
	else
		echo "FAIL $name (stdout differs)"
		diff -u "$exp" "$tmp" || true
		[[ -s "${tmp}.err" ]] && {
			echo "--- stderr ---"
			cat "${tmp}.err"
		}
		((++failed)) || true
	fi
	rm -f "$tmp" "${tmp}.err"
done

echo
echo "Results: ${passed} passed, ${failed} failed"
exit $((failed > 0 ? 1 : 0))
