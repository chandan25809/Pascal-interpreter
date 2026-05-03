class Person {
    private name: string;

    constructor Create;  // Use parameterless constructor
    begin
        name := "unknown";
    end;

    public procedure setName(newName: string);
    begin
        name := newName;
    end;

    public function getName(): string;
    begin
        writeln(name);
    end;
}.

begin
    var p: Person;
    p := Person.Create();     // Parameterless object creation
    p.setName("John");       // Use setter to assign the name
    p.getName();             // Display the name
end.
