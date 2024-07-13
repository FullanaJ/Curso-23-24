import 'dart:ffi';

import 'package:flutter/material.dart';

class FourthScreen extends StatelessWidget {
  FourthScreen({super.key, required this.comarca});

  Map<String, Object> comarca;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        backgroundColor: Theme.of(context).colorScheme.inversePrimary,
        title: Text('${comarca['comarca']}'),
      ),
      body: const Column(
        children: [],
      ),
      bottomNavigationBar: BottomNavigationBarExample(
        comarca: comarca,
      ),
    );
  }
}

class BottomNavigationBarExample extends StatefulWidget {
  BottomNavigationBarExample({super.key, required this.comarca});

  Map<String, Object> comarca;

  @override
  State<BottomNavigationBarExample> createState() =>
      _BottomNavigationBarExampleState();
}

class _BottomNavigationBarExampleState
    extends State<BottomNavigationBarExample> {
  int _selectedIndex = 0;
  static List<Widget> _widgetOptions = <Widget>[];

  void _onItemTapped(int index) {
    setState(() {
      _selectedIndex = index;
    });
  }

  @override
  Widget build(BuildContext context) {
    inicializa();
    return Scaffold(
      appBar: AppBar(
        title: const Text('BottomNavigationBar Sample'),
      ),
      body: Center(
        child: _widgetOptions.elementAt(_selectedIndex),
      ),
      bottomNavigationBar: BottomNavigationBar(
        items: const <BottomNavigationBarItem>[
          BottomNavigationBarItem(icon: Icon(Icons.info), label: 'Home'),
          BottomNavigationBarItem(icon: Icon(Icons.sunny), label: 'Search'),
        ],
        currentIndex: _selectedIndex,
        selectedItemColor: Colors.amber[800],
        onTap: _onItemTapped,
      ),
    );
  }

  void inicializa() {

    _widgetOptions.add(Column(
      crossAxisAlignment: CrossAxisAlignment.start,
      children: [
        Image(
          image: NetworkImage(widget.comarca['img'] as String),
        ),
        const SizedBox(height: 30),
        Text(
          widget.comarca['comarca'] as String,
          style: const TextStyle(
            fontSize: 24,
            color: Colors.black54,
          ),
          textAlign: TextAlign.left,
        ),
        const SizedBox(height: 20),
        Text('Capital:${widget.comarca['capital'] as String}',
            style: const TextStyle(
              fontSize: 16,
              color: Colors.black,
            ),
            textAlign: TextAlign.left),
        const SizedBox(height: 20),
        Text(widget.comarca['desc'] as String),
      ],
    ));
    _widgetOptions.add(Column(
      children: [
        const Image(image: AssetImage('lib/src/weatherIcon.png')),
        const Row(
          crossAxisAlignment: CrossAxisAlignment.center,
          children: [
            Image(
                height: 20,
                width: 20,
                image: AssetImage('lib/src/barometerIcon.png')),
            Text(
              ' 5.4º ',
              style: TextStyle(
                fontSize: 16,
                color: Colors.black,
              ),
            ),
          ],
        ),
        const Column(
          crossAxisAlignment: CrossAxisAlignment.center,
          children: [
            Row(
              crossAxisAlignment: CrossAxisAlignment.center,
              children: [
                Image(
                    height: 20,
                    width: 20,
                    image: AssetImage('lib/src/windIcon.png')),
                Text(
                  ' 9.4km/h ',
                  style: TextStyle(
                    fontSize: 16,
                    color: Colors.black,
                  ),
                ),
              ],
            ),
          ],
        ),
        Text(
          'Poblacion: ${widget.comarca['poblacio'] as String}',
          style: const TextStyle(
            fontSize: 24,
            color: Colors.black,
          ),
        ),
        Text(
          'Latitud: ${widget.comarca['coordenades'].toString().split(',')[0].substring(1)}',
          style: const TextStyle(
            fontSize: 16,
            color: Colors.black,
          ),
        ),
        Text('Longitud: ${widget.comarca['coordenades'].toString().split(',')[1]}',
            style: const TextStyle(
              fontSize: 16,
              color: Colors.black,
            ),
            textAlign: TextAlign.left),
      ],
    ));
  }
}
