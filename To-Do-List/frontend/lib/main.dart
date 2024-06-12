import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatefulWidget {
  const MyApp({super.key});

  @override
  State<MyApp> createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  @override
  Widget build(BuildContext context) {
    return const MaterialApp(
      home: ToDoList(),
    );
  }
}

class ToDoList extends StatefulWidget {
  const ToDoList({super.key});

  @override
  State<ToDoList> createState() => _ToDoListState();
}

class _ToDoListState extends State<ToDoList> {
  @override
  Widget build(BuildContext context) {
       
    

    int typeTest = 1;
    List<TextEditingController> controllerTest = [];
    for(int i = 0; i <= 8; i++ ){
controllerTest.add(TextEditingController());
    }


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
          ),
        ),
        child: Column(
          mainAxisAlignment: MainAxisAlignment.start,
          children: [
            const SizedBox(height: 50),
            const Text(
              'To-do-List',
              style: TextStyle(fontSize: 32, fontWeight: FontWeight.bold),
            ),
             SizedBox(
              height: MediaQuery.of(context).size.height * 0.015 ,
            ),
            Expanded(
              child: ListView.builder(
                itemCount: 8,
                itemBuilder: (context, index) {
                  return Container(
                    margin: EdgeInsets.fromLTRB(
                        MediaQuery.of(context).size.width * 0.1,
                        20,
                        MediaQuery.of(context).size.width * 0.1,
                        0),
                    decoration: BoxDecoration(
                      gradient: LinearGradient(
                        colors: index % 2 == 0
                            ? [Colors.green[400]!, Colors.green[300]!]
                            : [Colors.red[400]!, Colors.red[300]!],
                      ),
                      borderRadius: BorderRadius.circular(10),
                    ),
                    height: 75,
                    child: ListTile(
                      //DESCRIÇÃO
                      title:  TextField(
                        controller: controllerTest[index],
                        decoration: const InputDecoration(
                          border: InputBorder.none,
                          //adicione a vairavel para permitir editar
                          enabled: true,
                          label: Text("Insira o nome da tarefa")
                        ),
                      ),
                      //DATA
                      subtitle: typeTest == 1 ?
                      const Text("Para: XX/XX/XXXX  Dias Restantes: XX") :
                      typeTest == 2 ?
                      const Text("Dias restantes: XX") :
                      const Text("Sem prazo"),
                      trailing: Row(
                        mainAxisSize: MainAxisSize.min,
                        children: [
                          //EDIT
                          IconButton(
                            icon: const Icon(Icons.edit),
                            onPressed: () {
                              setState(() {
                                 if(typeTest != 3){
                                  typeTest++;
                                }else{
                                  typeTest = 1;
                                }
                              });
                               
                            },
                          ),
                          //DELETE
                          //Para deletar vc deve integrar e remover da lista com um setstate, mas primeiro vc deve puxar a lista de tarefas do back
                          IconButton(
                            icon: const Icon(Icons.delete),
                            onPressed: () {},
                          ),
                        ],
                      ),
                    ),
                  );
                },
              ),
            ),
             SizedBox(
              height: MediaQuery.of(context).size.height * 0.015 ,
            ),
            InkWell(
              onTap: () {},
              child: Container(
                width: MediaQuery.of(context).size.width * 0.245,
                height: 60,
                decoration: BoxDecoration(
                  color: const Color.fromARGB(95, 255, 255, 255),
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
                  child:  Text(
                    "+",
                    style: TextStyle(
                      fontSize: 40,
                      color: Colors.black,
                    ),
                  ),
                ),
              ),
            ),
             SizedBox(
              height: MediaQuery.of(context).size.height * 0.05 ,
            ),
          ],
        ),
      ),
    );
  }
}
