import 'package:flutter/material.dart';
import 'SecondScreen.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Comarcas',
      theme: ThemeData(
        colorScheme: ColorScheme.fromSeed(seedColor: Colors.deepPurple),
        useMaterial3: true,
      ),
      home: const MyHomePage(title: 'Comarcas'),
    );
  }
}

class MyHomePage extends StatefulWidget {
  const MyHomePage({super.key, required this.title});

  final String title;

  @override
  State<MyHomePage> createState() => _MyHomePageState();
}

class TextName extends StatelessWidget {
  const TextName({super.key, text});

  @override
  Widget build(BuildContext context) {
    return SizedBox(
      width: 250,
      child: Padding(
        padding: const EdgeInsets.symmetric(vertical: 20),
        child: Container(
          color: Colors.white,
          // Establece el color de fondo del Container en blanco
          child: const TextField(
            decoration: InputDecoration(
              border: OutlineInputBorder(),
              labelText: 'Name',
            ),
          ),
        ),
      ),
    );
  }
}

class TextPass extends StatelessWidget {
  const TextPass({super.key, text});

  @override
  Widget build(BuildContext context) {
    return SizedBox(
      width: 250,
      child: Padding(
        padding: const EdgeInsets.symmetric(vertical: 20),
        child: Container(
          color: Colors.white,
          child: const TextField(
            obscureText: true,
            decoration: InputDecoration(
              border: OutlineInputBorder(),
              labelText: 'Password',
            ),
          ),
        ),
      ),
    );
  }
}

class ButtonStart extends StatelessWidget {
  const ButtonStart({super.key});

  void crearNuevaIterfaz(BuildContext context) {
    Navigator.push(
      context,
      MaterialPageRoute(builder: (context) => const SecondScreen()),
    );
  }

  @override
  Widget build(BuildContext context) {
    return SizedBox(
      width: 250,
      child: Padding(
        padding: const EdgeInsets.symmetric(vertical: 20),
        child: FilledButton(
            onPressed: () => crearNuevaIterfaz(context),
            child: const Text("Enter")),
      ),
    );
  }
}

class _MyHomePageState extends State<MyHomePage> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        backgroundColor: Theme.of(context).colorScheme.inversePrimary,
        title: Text(widget.title),
      ),
      body: Container(
        decoration: const BoxDecoration(
          image: DecorationImage(
            image: AssetImage('lib/src/travel.jpg'),
            fit: BoxFit.cover, // Ajusta la forma en que se ajusta la imagen
          ),
        ),
        child: const Center(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: <Widget>[
              Image(image: AssetImage('lib/src/login.png')),
              Text("Les Comarques de\nla comunitat",
                  textAlign: TextAlign.center),
              TextName(),
              TextPass(),
              ButtonStart()
            ],
          ),
        ),
      ),
    );
  }
}
