import 'package:flutter/material.dart';

class Screen1 extends StatelessWidget {
  const Screen1({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('please login'),
        leading: Icon(Icons.menu),
      ),
      body: const Center(
        child: Column(
              mainAxisAlignment: MainAxisAlignment.center,
              children: [
                Icon(
                  Icons.person, 
                  color: Colors.blue,
                  size: 120,
                ),
                SizedBox(
                  height:50.0,
                ),
                Row(
                  mainAxisAlignment: MainAxisAlignment.center,
                  children: [
                    Text('ID : ', style: TextStyle(
                      fontSize: 30.0,
                      color: Colors.black,
                      fontWeight: FontWeight.bold,
                    ),),
                    // Typing ID Widget needed - Connection with server 
                    SizedBox( 
                      width: 150.0,
                    )
                  ],
                ),
                SizedBox(
                  height:10.0,
                ),
                Row(
                  mainAxisAlignment: MainAxisAlignment.center,
                  children: [
                    Text('PW : ', style: TextStyle(
                      fontSize: 30.0,
                      color: Colors.black,
                      fontWeight: FontWeight.bold,
                    ),),
                    // Typing ID Widget needed - Connection with server 
                    SizedBox(
                      width: 150.0,
                    )
                  ],
                ), 
                SizedBox(
                  height:80.0,
                ),
                Row(
                  mainAxisAlignment: MainAxisAlignment.center,
                  children: [
                    Icon(
                      Icons.home, 
                      color: Colors.blue,
                      size: 40,
                    ),
                    SizedBox(
                      width: 25.0,
                    ),
                    Icon(
                      Icons.access_alarm, 
                      color: Colors.blue,
                      size: 40,
                    ),
                    SizedBox(
                      width: 25.0,
                    ),
                    Icon(
                      Icons.ac_unit, 
                      color: Colors.blue,
                      size: 40,
                    ),
                  ],
                ),  
              ],
            ),
      ),
    );
  }
}