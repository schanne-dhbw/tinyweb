/*
def handleGreetingRequest(request: HttpRequest) =
  Map("greetings" -> request.body.split(",").toList.map(makeGreeting))

private def random = new Random()

private def greetings = Vector("Hello", "Greetings", "Salutations", "Hola")

private def makeGreeting(name: String) =
  "%s, %s".format(greetings(random.nextInt(greetings.size)), name)

def greetingController = new FunctionController(greetingView, handleGreetingRequest)
*/