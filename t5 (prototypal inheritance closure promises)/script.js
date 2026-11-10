console.log("=== 1. PROTOTYPAL INHERITANCE ===");
function Person(name, age) {
    this.name = name;
    this.age = age;
}

Person.prototype.greet = function() {
    return `Hello, my name is ${this.name} and I am ${this.age} years old.`;
};

function Student(name, age, rollNo, course) {
    Person.call(this, name, age);
    this.rollNo = rollNo;
    this.course = course;
}

Student.prototype = Object.create(Person.prototype);
Student.prototype.constructor = Student;

Student.prototype.getDetails = function() {
    return `${this.name} (Roll No: ${this.rollNo}) is enrolled in ${this.course}.`;
};

const s1 = new Student("Rahul", 20, "101", "Computer Science");
console.log(s1.greet());
console.log(s1.getDetails());


console.log("\n=== 2. CLOSURE ===");
function createCounter(initialValue = 0) {
    let count = initialValue;

    return {
        increment: function() {
            count++;
            return `Count: ${count}`;
        },
        decrement: function() {
            count--;
            return `Count: ${count}`;
        },
        getCount: function() {
            return `Current Count: ${count}`;
        }
    };
}

const counter = createCounter(10);
console.log(counter.increment());
console.log(counter.increment());
console.log(counter.decrement());
console.log(counter.getCount());


console.log("\n=== 3. CALLBACKS ===");
function fetchUserDataCallback(userId, callback) {
    console.log(`[Callback] Fetching data for user ID: ${userId}...`);
    setTimeout(() => {
        const user = { id: userId, name: "Priya", role: "Developer" };
        callback(null, user);
    }, 500);
}

fetchUserDataCallback(101, (err, user) => {
    if (err) {
        console.error("[Callback] Error:", err);
        return;
    }
    console.log(`[Callback] User fetched: ${user.name}, Role: ${user.role}`);
    runPromisesAndAsync();
});


function runPromisesAndAsync() {
    console.log("\n=== 4. PROMISES ===");
    function fetchMarksPromise(rollNo) {
        return new Promise((resolve, reject) => {
            console.log(`[Promise] Fetching marks for roll number: ${rollNo}...`);
            setTimeout(() => {
                const marks = { "Web Technologies": 95, "Database Systems": 90 };
                if (rollNo) {
                    resolve(marks);
                } else {
                    reject("Invalid Roll Number");
                }
            }, 500);
        });
    }

    fetchMarksPromise("101")
        .then((marks) => {
            console.log("[Promise] Marks received:", JSON.stringify(marks));
        })
        .catch((error) => {
            console.error("[Promise] Error:", error);
        })
        .finally(() => {
            console.log("[Promise] Promise operation completed.");
            runAsyncAwait();
        });
}


async function runAsyncAwait() {
    console.log("\n=== 5. ASYNC / AWAIT ===");
    function getStudentReport(id) {
        return new Promise((resolve, reject) => {
            setTimeout(() => {
                if (id > 0) {
                    resolve({ id: id, grade: "A+", status: "Passed" });
                } else {
                    reject("Student not found");
                }
            }, 500);
        });
    }

    try {
        console.log("[Async/Await] Requesting report for student ID: 101...");
        const report = await getStudentReport(101);
        console.log(`[Async/Await] Report received: Grade = ${report.grade}, Status = ${report.status}`);
    } catch (error) {
        console.error("[Async/Await] Failed:", error);
    } finally {
        console.log("[Async/Await] Async/Await execution finished.");
        console.log("\nAll 5 JavaScript concepts demonstrated successfully!");
    }
}
