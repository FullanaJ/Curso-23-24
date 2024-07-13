import 'package:comarcas_app/FourthScreen.dart';
import 'package:flutter/material.dart';

class ThirdScreen extends StatefulWidget {
  ThirdScreen(List<Map<String, Object>> provincia, this.name, {super.key}) {
    provinca = provincia;
  }

  String name = '';
  List<Map<String, Object>>? provinca;

  @override
  State<ThirdScreen> createState() => _ThirdScreenState();
}

class _ThirdScreenState extends State<ThirdScreen> {
  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return Scaffold(
          appBar: AppBar(
            backgroundColor: Theme
                .of(context)
                .colorScheme
                .inversePrimary,
            title: Text('Comarcas de ${widget.name}'),
          ),
          body: Container(
            child: ListView.builder(
              itemCount: widget.provinca?.length,
              itemBuilder: (context, index) {
                final comarca = widget.provinca![index];
                return GestureDetector(
                  child: Padding(
                    padding: const EdgeInsets.symmetric(vertical: 8.0),
                    child: Container(
                      height: 150,
                      decoration: BoxDecoration(
                        image: DecorationImage(
                          image: NetworkImage(comarca['img'] as String),
                          fit: BoxFit
                              .cover, // Ajusta la forma en que se ajusta la imagen
                        ),
                      ),
                      child: Positioned(
                        child: Align(
                          alignment: Alignment.bottomLeft,
                          child: Container(
                            color: Colors.black.withOpacity(0.5),
                            // Agrega un fondo oscuro al texto para que sea más legible
                            padding: const EdgeInsets.symmetric(
                                horizontal: 8, vertical: 4),
                            // Ajusta el espaciado del texto
                            child: Text(
                              comarca['comarca'] as String,
                              style: const TextStyle(
                                fontSize: 16,
                                color: Colors
                                    .white, // Ajusta el color del texto si es necesario
                              ),
                            ),
                          ),
                        ),
                      ),
                    ),
                  ),
                  onTap: () {
                    Navigator.push(
                      context,
                      MaterialPageRoute(
                          builder: (context) =>
                              FourthScreen(comarca:comarca),
                    ),
                    );
                  },
                );
              },
            ),
          ),
        );
  }
}
