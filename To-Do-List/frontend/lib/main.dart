import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return const MaterialApp(
      home: ToDoList(),
    );
  }
}

class ToDoList extends StatelessWidget {
  const ToDoList({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Container(
        decoration: const BoxDecoration(
            gradient: LinearGradient(
          begin: Alignment.topLeft,
          end: Alignment.bottomRight,
          colors: [
            Color(0xFFEBADF5),
            Color(0xFFD9C1C1),
          ],
        )),
        child: SizedBox(
          width: double.infinity,
          height: double.infinity,
          child: Center(
            child: Column(
              mainAxisAlignment: MainAxisAlignment.center,
              children: [
                const SizedBox(height: 50),
                const Text(
                  'To-Do-List',
                  style: TextStyle(fontSize: 32),
                ),
                Expanded(
                  child: ListView.builder(
                    itemCount: 5,
                    itemBuilder: (context, index) {
                      return Container(
                        margin: EdgeInsets.fromLTRB(
                            MediaQuery.of(context).size.width * 0.3,
                            20,
                            MediaQuery.of(context).size.width * 0.3,
                            0),
                        height: 75,
                        child: Row(
                          mainAxisAlignment: MainAxisAlignment.center,
                          children: [
                            Container(
                              color: index % 2 == 0
                                  ? const Color(0xFF83F471)
                                  : const Color(0xFFFF4646),
                              width: 200,
                              child: Padding(
                                padding: const EdgeInsets.fromLTRB(10, 0, 0, 0),
                                child: TextField(
                                  decoration: InputDecoration(
                                      labelText: "Item $index",
                                      border: InputBorder.none),
                                ),
                              ),
                            ),
                            Center(
                              child: Container(
                                 color: index % 2 == 0
                                    ? const Color(0xFF83F471)
                                    : const Color(0xFFFF4646),
                                 width: 150,
                                 height: 50,
                                child: const Center(child: Text("Livre"))
                              ),
                            ),
                            const SizedBox(width: 5),
                           InkWell(
                                onTap: () {},
                                child: const Icon(Icons.edit, size: 24),
                              ),
                          ],
                        ),
                      );
                    },
                  ),
                ),
                const SizedBox(
                  height: 20,
                ),
                InkWell(
                  child: Container(
                    width: MediaQuery.of(context).size.width * 0.4,
                    height: 60,
                    decoration: BoxDecoration(
                      color: Colors.white,
                      boxShadow: [
                        BoxShadow(
                          color: Colors.grey.withOpacity(0.5),
                          spreadRadius: 5,
                          blurRadius: 7,
                          offset: const Offset(0, 3),
                        ),
                      ],
                    ),
                    child: const Center(
                      child: Text(
                        "+",
                        style: TextStyle(
                          fontSize: 60,
                          color: Colors.black,
                        ),
                      ),
                    ),
                  ),
                ),
                const SizedBox(
                  height: 40,
                ),
              ],
            ),
          ),
        ),
      ),
    );
  }
}
