package pt.tecnico.mydrive.presentation;



public class MydriveShell extends Shell {

  private long _token;

  public static void main(String[] args) throws Exception {
    MydriveShell sh = new MydriveShell();
    sh.execute();
  }

  public MydriveShell() {
    super("MyDrive");
    /* Add commands from here below */
    //new CreatePerson(this);
    //new CreateContact(this);
    //new RemovePerson(this);
    //new RemoveContact(this);
    new List(this);
    //new Import(this);
    //new Export(this);
  }

  public long getToken(){
    return _token;
  }
}