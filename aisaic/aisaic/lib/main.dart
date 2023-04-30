import 'package:flutter/material.dart';
import 'login.dart';

void main () => runApp(const MyApp());

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      initialRoute: '/',
      routes: { //Write Page with route 
        // '/' :(context) => main(),
        '/1' :(context) => const login(),
        // '/c' :(context) => Screen3()
      },
      debugShowCheckedModeBanner: false,
      title: 'aisaic',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: const WelcomePage(), //First page to start
    );
}
}

class WelcomePage extends StatelessWidget {
  const WelcomePage({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.white,
      body: SafeArea(
        child: Center(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              const Icon( //Our Application logo
                Icons.person, 
                color: Colors.blue,
                size: 120,
              ),
              const Text('aisaic',
              style: TextStyle(
                fontSize: 50.0,
                color: Colors.black,
                fontWeight: FontWeight.bold,
              ),),
              const SizedBox(
                height: 80.0,
              ),
              ElevatedButton( //Change to Timer later 
                onPressed: () {
                  Navigator.pushNamed(context, '/1');
                },
                style: ElevatedButton.styleFrom(
                  backgroundColor: Colors.blue,
                ),
                child: const Text('시작하기', style: TextStyle(
                  fontWeight: FontWeight.bold,
                ),),
                )
        
            ],
          ),
        )
      ),
    );
  }
}
