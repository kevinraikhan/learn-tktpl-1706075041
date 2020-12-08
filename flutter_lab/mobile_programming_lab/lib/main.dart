import 'package:flutter/material.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      theme: ThemeData(
        primarySwatch: Colors.blue,
        visualDensity: VisualDensity.adaptivePlatformDensity,
      ),
      home: MyHomePage(),
    );
  }
}

class MyHomePage extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Color.fromRGBO(8, 33, 49, 1),
      appBar: AppBar(
        title: Text("Hello World"),
      ),
      body: MyStatefulWidget(),
    );
  }
}

class MyStatefulWidget extends StatefulWidget {
  @override
  _MyStatefulWidgetState createState() => _MyStatefulWidgetState();
}

class _MyStatefulWidgetState extends State<MyStatefulWidget> {
  final controller = TextEditingController();
  String text = "Write your name";

  @override
  void dispose() {
    super.dispose();
    controller.dispose();
  }

  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: const EdgeInsets.only(left: 25, right: 25, top: 52),
      child: Column(
        children: [
          Row(
            children: [
              Text(
                "Hello, ",
                style: TextStyle(
                    color: Colors.white,
                    fontSize: 28,
                    fontWeight: FontWeight.w500),
              ),
              Text(
                this.text,
                style: TextStyle(
                    color: Color.fromRGBO(255, 218, 21, 1),
                    fontSize: 30,
                    fontWeight: FontWeight.w700),
              )
            ],
            mainAxisAlignment: MainAxisAlignment.center,
          ),
          TextField(
            style: TextStyle(color: Colors.white),
            controller: this.controller,
            decoration: InputDecoration(
              hintText: 'Your Name',
              hintStyle: TextStyle(color: Color.fromRGBO(255, 255, 255, 0.5)),
              enabledBorder: UnderlineInputBorder(
                borderSide: BorderSide(color: Colors.white),
              ),
              focusedBorder: UnderlineInputBorder(
                borderSide: BorderSide(color: Colors.white),
              ),
              border: UnderlineInputBorder(
                borderSide: BorderSide(color: Colors.white),
              ),
            ),
          ),
          Padding(
            padding: EdgeInsets.only(top: 42),
            child: ButtonTheme(
              buttonColor: Color.fromRGBO(255, 218, 21, 1),
              minWidth: double.infinity,
              child: RaisedButton(
                  child: Padding(
                    padding: const EdgeInsets.all(10.0),
                    child: Text(
                      "Hello",
                      style: TextStyle(
                          fontWeight: FontWeight.w700,
                          fontSize: 22,
                          color: Color.fromRGBO(8, 33, 49, 1)),
                    ),
                  ),
                  onPressed: () => setState(() {
                        this.text = controller.text;
                      })),
            ),
          )
        ],
      ),
    );
  }
}
