class MyClass {
    private x: integer;

    public procedure setX(val: integer);
    begin
        x := val;
        end;

    public function getX(): integer;
    begin
        return x;
        end;
}.

begin
    var a: MyClass;
    var b: MyClass;
    a := MyClass.Create();
    b := MyClass.Create();
    a.setX(1);
    b.setX(2);
    a.getX();
    b.getX();
end.
