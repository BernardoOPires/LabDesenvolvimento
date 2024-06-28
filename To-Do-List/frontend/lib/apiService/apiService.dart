import 'dart:convert';
import 'package:http/http.dart' as http;
import 'package:frontend/tarefas/entityTest.dart'; 

class ApiService {
  final String baseUrl = 'http://localhost:8080/api/tasks';

  //search
  Future<List<TarefasTest>> fetchTasks() async {
    final response = await http.get(Uri.parse(baseUrl));
    print(response);
    if (response.statusCode == 200) {
      List<dynamic> body = jsonDecode(response.body);
      List<TarefasTest> tasks = body.map((dynamic item) => TarefasTest.fromJson(item)).toList();
      return tasks;
    } else {
      throw Exception('falha na busca');
    }
  }

  //create
  Future<TarefasTest> addTask(Map<String, dynamic> task) async {
    print(Uri.parse(baseUrl));
    final response = await http.post(
      Uri.parse(baseUrl),
      headers: {'Content-Type': 'application/json'},
      body: jsonEncode(task),
    );
     print(response);
    if (response.statusCode == 201) {
      return TarefasTest.fromJson(jsonDecode(response.body));
    } else {
      throw Exception('falha ao criar');
    }
  }

  //update
  Future<TarefasTest> updateTask(String id, Map<String, dynamic> task) async {
    final response = await http.put(
      Uri.parse('$baseUrl/$id'),
      headers: {'Content-Type': 'application/json'},
      body: jsonEncode(task),
    );
    if (response.statusCode == 200) {
      return TarefasTest.fromJson(jsonDecode(response.body));
    } else {
      throw Exception('falha ao atualizar');
    }
  }

  //delete
  Future<void> deleteTask(String id) async {
    final response = await http.delete(Uri.parse('$baseUrl/$id'));
    if (response.statusCode != 204) {
      throw Exception('falha ao deletar');
    }
  }
}
