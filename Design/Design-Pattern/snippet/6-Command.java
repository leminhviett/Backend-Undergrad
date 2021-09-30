class Command{
	Receiver receiver;

	//constructor

	public void execute() {
		receiver.doSth()
	}

}

class Invoker{
	Command command

	public setCommand(Command command) {
		this.command = command
	}

	public executeCommand() {
		this.command.execute()
	}
}

class Receiver{

	public void doSth()
}




class Client{

	Command c = new Command(invoker)
	Invoker i = new Invoker()

	i.setCommand(c)
	i.executeCommand(c)
}