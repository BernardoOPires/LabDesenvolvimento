class TarefasTest {
  late int id;
  late String description;
  bool completed = false;
  late DateTime startDate;
  late DateTime dueDate;
  late int type; // 1 - Data, 2 - Dias Restantes, 3 - sem prazo
  late int priority; // 1 - baixa, 2 - media, 3 - alta

  TarefasTest({
    required this.id,
    required this.description,
    this.completed = false,
    required this.startDate, 
    required this.dueDate,
    required this.type,
    required this.priority,
  });

  factory TarefasTest.fromJson(Map<String, dynamic> json) {
    return TarefasTest(
      id: json['id'],
      description: json['description'],
      completed: json['completed'] ?? false,
      startDate: DateTime.parse(json['startDate']),
      dueDate: DateTime.parse(json['dueDate']),
      type: json['type'],
      priority: json['priority'],
    );
  }

  Map<String, dynamic> toJson() {
    return {
      'id': id,
      'description': description,
      'completed': completed,
      'startDate': startDate.toIso8601String(),
      'dueDate': dueDate.toIso8601String(),
      'type': type,
      'priority': priority,
    };
  }
}
