import 'package:flutter/material.dart';
import 'package:frontend/apiService/apiService.dart';
import 'package:frontend/tarefas/entityTest.dart';

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

// Estado para o StatefulWidget ToDoList.
class _ToDoListState extends State<ToDoList> {
  List<TarefasTest> tasks = []; // Lista para armazenar tarefas
  final ApiService apiService = ApiService(); // Instância do serviço API

  @override
  void initState() {
    super.initState();
    _fetchTasks();
  }

  void _fetchTasks() async {
    try {
      var fetchedTasks = await apiService.fetchTasks();
      setState(() {
        tasks = fetchedTasks;
      });
    } catch (e) {
      print('Erro na tarefa: $e');
    }
  }

  @override
  Widget build(BuildContext context) {
    int typeTest = 1;
    List<TextEditingController> controllerTest = [];
    for (int i = 0; i <= 8; i++) {
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
              height: MediaQuery.of(context).size.height * 0.015,
            ),
            Expanded(
              child: ListView.builder(
                itemCount: tasks.length,
                itemBuilder: (context, index) {
                  final task = tasks[index];
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
                      title: TextField(
                        controller: TextEditingController(
                            text: task
                                .description), // controller para adicioar texto
                        decoration: const InputDecoration(
                            border: InputBorder.none,
                            enabled: true,
                            label: Text("Insira o nome da tarefa")),
                        onSubmitted: (newValue) {
                          //atualizar ao colocar nova descrição
                          task.description = newValue;
                          apiService.updateTask(task.id.toString(),
                              task.toJson()); //atualizar back
                        },
                      ),
                      subtitle: Text(
                          "Para: ${task.dueDate.toIso8601String()}"), //data da tarefa
                      trailing: Row(
                        mainAxisSize: MainAxisSize.min,
                        children: [
                          IconButton(
                            icon: const Icon(Icons.edit),
                            onPressed: () {
                              // Abre um modal ou outra página para editar a tarefa mais detalhadamente
                            },
                          ),
                          IconButton(
                            icon: const Icon(Icons.delete),
                            onPressed: () async {
                              await apiService.deleteTask(
                                  task.id.toString()); // deletar tarefa
                              _fetchTasks(); // muda a lista com delete
                            },
                          ),
                        ],
                      ),
                    ),
                  );
                },
              ),
            ),
            SizedBox(
              height: MediaQuery.of(context).size.height * 0.015,
            ),
            InkWell(
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
                  child: Text(
                    "+",
                    style: TextStyle(
                      fontSize: 40,
                      color: Colors.black,
                    ),
                  ),
                ),
              ),
              onTap: () async {
                TarefasTest newTask = TarefasTest(
                  id: 0, // back arruma id
                  description: 'Nova Tarefa',
                  startDate: DateTime.now(),
                  dueDate: DateTime.now().add(const Duration(days: 7)),
                  type: 1,
                  priority: 1,
                );
                await apiService.addTask(newTask.toJson());
                _fetchTasks(); // att com o novo item
              },
            ),
            SizedBox(
              height: MediaQuery.of(context).size.height * 0.05,
            ),
          ],
        ),
      ),
    );
  }
}

TarefasTest createEmptyTask() {
  return TarefasTest(
    id: 0, // id temp
    description: '',
    startDate: DateTime.now(),
    dueDate: DateTime.now().add(const Duration(days: 7)),
    type: 1, // crie metodo para inserir os 2 valores
    priority: 1,
  );
}


//  Exemplo do uso da lista
// ListView.builder(
//   itemCount: tasks.length,
//   itemBuilder: (context, index) {
//     TarefasTest task = tasks[index];
//     return ListTile(
//       title: Text(task.description),
//       subtitle: Text('Due Date: ${task.dueDate}'),
//       trailing: IconButton(
//         icon: Icon(task.completed ? Icons.check_box : Icons.check_box_outline_blank),
//         onPressed: () {
//           // Adicionar lógica para alternar o estado de completado
//         },
//       ),
//     );
//   },
// )