import 'package:comarcas_app/ThirdScreen.dart';
import 'package:flutter/material.dart';
import 'Comarques.dart';

class SecondScreen extends StatelessWidget {
  const SecondScreen({super.key});

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return const MyHomePageState();
  }
}

class MyHomePageState extends StatefulWidget {
  const MyHomePageState({super.key});

  @override
  State<MyHomePageState> createState() => _MyHomePageStateState();
}

class _MyHomePageStateState extends State<MyHomePageState> {
  List<dynamic> provinciesList = provincies['provincies'];

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
          backgroundColor: Theme.of(context).colorScheme.inversePrimary,
          title: const Text("Comarcas"),
        ),
        body: Container(
          decoration: const BoxDecoration(
            image: DecorationImage(
              image: AssetImage('lib/src/travel.jpg'),
              fit: BoxFit.cover, // Ajusta la forma en que se ajusta la imagen
            ),
          ),
          child: ListView.builder(
            itemCount: provincies['provincies'].length,
            itemBuilder: (context, index) {
              final provincia = provincies['provincies'][index];
              return Padding(
                padding: const EdgeInsets.symmetric(vertical: 8.0),
                child: SizedBox(
                  width: 250,
                  // Ajusta el ancho del SizedBox según tu preferencia
                  height: 250,
                  // Ajusta la altura del SizedBox según tu preferencia
                  child: GestureDetector(
                      child: CircleAvatar(
                        backgroundImage: NetworkImage(provincia['img']),
                        radius: 40,
                        // Ajusta el radio del CircleAvatar según tu preferencia
                        backgroundColor: Colors.grey[300],
                        // Color de fondo opcional
                        child: Text(
                          provincia['provincia'],
                          style: const TextStyle(
                            fontSize: 50,
                            color: Colors.white,
                          ),
                        ), // Puedes mostrar una letra o icono en el avatar
                      ),
                      onTap: () => {
                            Navigator.push(
                              context,
                              MaterialPageRoute(
                                  builder: (context) => ThirdScreen(
                                      provincia['comarques'],
                                      provincia['provincia'])),
                            ),
                          }),
                ),
              );
            },
          ),
        ));
  }
}
