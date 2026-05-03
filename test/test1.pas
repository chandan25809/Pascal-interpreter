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
    var obj: MyClass;
    obj := MyClass.Create();
    obj.setX(10);
    obj.getX();
end.