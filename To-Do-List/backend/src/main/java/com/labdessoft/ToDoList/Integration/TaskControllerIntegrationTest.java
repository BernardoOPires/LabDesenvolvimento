// package com.labdessoft.ToDoList.Integration;

// import com.labdessoft.ToDoList.ToDoListApplication;
// import io.restassured.RestAssured;
// import io.restassured.http.ContentType;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import org.junit.jupiter.api.extension.ExtendWith;
// import org.mockito.junit.jupiter.MockitoExtension;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.boot.test.web.server.LocalServerPort;
// import org.springframework.test.context.ActiveProfiles;

// import static io.restassured.RestAssured.given;
// import static org.hamcrest.Matchers.equalTo;

// @SpringBootTest(classes = ToDoListApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
// @ExtendWith(MockitoExtension.class)
// @ActiveProfiles("test")
// public class TaskControllerIntegrationTest {

//     @LocalServerKeepPort
//     private int port;

//     @BeforeEach
//     public void setup() {
//         RestAssured.baseURI = "http://localhost";
//         RestAssured.port = port;
//     }

//     @Test
//     public void givenUrl_whenSuccessOnGetsResponseAndJsonHasRequiredKV_thenCorrect() {
//         get("/api/tasks").then().statusCode(200);
//     }

//     @Test
//     public void givenUrl_whenSuccessOnGetsResponseAndJsonHasOneTask_thenCorrect() {
//         get("/api/tasks/1").then().statusCode(200)
//             .assertThat().body("description", equalTo("Primeira tarefa"));
//     }

//     @Test
//     public void testCreateTask() {
//         Task newTask = new Task("Nova tarefa", false);
//         given()
//             .contentType(ContentType.JSON)
//             .body(newTask)
//             .when()
//             .post("/tasks")
//             .then()
//             .statusCode(201)
//             .body("description", equalTo("Nova tarefa"));
//     }

//     @Test
//     public void testUpdateTask() {
//         Task updatedTask = new Task("Tarefa atualizada", false);
//         updatedTask.setId(1L);  
//         given()
//             .contentType(ContentType.JSON)
//             .body(updatedTask)
//             .when()
//             .put("/tasks/1")
//             .then()
//             .statusCode(200)
//             .body("description", equalTo("Tarefa atualizada"));
//     }

//     @Test
//     public void testDeleteTask() {
//         given()
//             .when()
//             .delete("/tasks/1")
//             .then()
//             .statusCode(204);
//     }

//     @Test
//     public void testToggleTaskStatus() {
//         given()
//             .when()
//             .patch("/tasks/1/toggle-status")
//             .then()
//             .statusCode(200)
//             .body("completed", equalTo(true));
//     }
// }
