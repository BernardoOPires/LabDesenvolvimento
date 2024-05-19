DROP TABLE IF EXISTS task;
CREATE TABLE task (
  id INT AUTO_INCREMENT PRIMARY KEY,
  description VARCHAR(250) NOT NULL,
  completed BOOLEAN,
  startDate DATE,
  dueDate DATE,
  type VARCHAR(20)
);
