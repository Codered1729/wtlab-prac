// Experiment 5: JavaScript Program to demonstrate working of:
// 1. Prototypal Inheritance
// 2. Closure
// 3. Callbacks
// 4. Promises
// 5. Async / Await

console.log("=== 1. PROTOTYPAL INHERITANCE ===");
// Base Constructor Function
function Person(name, age) {
    this.name = name;
    this.age = age;
}

// Adding method to Person prototype
Person.prototype.greet = function() {
    return `Hello, my name is ${this.name} and I am ${this.age} years old.`;
};

// Derived Constructor Function
function Student(name, age, rollNo, course) {
    Person.call(this, name, age); // Call super constructor
    this.rollNo = rollNo;
    this.course = course;
}

// Inherit from Person prototype
Student.prototype = Object.create(Person.prototype);
Student.prototype.constructor = Student;

// Adding Student-specific method
Student.prototype.getDetails = function() {
    return `${this.name} (Roll No: ${this.rollNo}) is enrolled in ${this.course}.`;
};

const s1 = new Student("Rahul", 20, "101", "Computer Science");
console.log(s1.greet());      // Inherited method from Person
console.log(s1.getDetails()); // Student's own prototype method


console.log("\n=== 2. CLOSURE ===");
// A closure gives an inner function access to an outer function's scope.
function createCounter(initialValue = 0) {
    let count = initialValue; // Private variable enclosed in outer scope

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
console.log(counter.increment()); // Count: 11
console.log(counter.increment()); // Count: 12
console.log(counter.decrement()); // Count: 11
console.log(counter.getCount());  // Current Count: 11


console.log("\n=== 3. CALLBACKS ===");
// A callback is a function passed into another function as an argument.
function fetchUserDataCallback(userId, callback) {
    console.log(`[Callback] Fetching data for user ID: ${userId}...`);
    setTimeout(() => {
        const user = { id: userId, name: "Priya", role: "Developer" };
        callback(null, user);
    }, 500);
}

// Invoking callback
fetchUserDataCallback(101, (err, user) => {
    if (err) {
        console.error("[Callback] Error:", err);
        return;
    }
    console.log(`[Callback] User fetched: ${user.name}, Role: ${user.role}`);

    // Continuing with Promises and Async/Await after callback finishes
    runPromisesAndAsync();
});


function runPromisesAndAsync() {
    console.log("\n=== 4. PROMISES ===");
    // A Promise represents the eventual completion or failure of an async operation.
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

    // Using .then(), .catch(), and .finally()
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
    // Async/Await provides a cleaner syntax for working with Promises.
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

