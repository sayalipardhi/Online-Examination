## Online Examination System (Java)

This is a simple console-based Online Examination System built using Java.  
The user logs in, updates profile/password, and attempts an MCQ exam with a timer.

## Features
- Login  
- Update Profile  
- Update Password  
- Attempt MCQ Exam  
- 30-Second Timer & Auto-Submit  
- Logout  

## Project Structure
Online-Examination-System  
│── bin  
│── lib  
└── src  
    └── OnlineExamination.java  

## How to Run
1. Open the project in VS Code  
2. Go to the **src** folder  
3. Compile: `javac OnlineExamination.java`  
4. Run: `java OnlineExamination`

## Sample Output
```text
===== ONLINE EXAM SYSTEM =====
Enter Username: Sayali Pardhi
Enter Password: 1627

Login Successful!

===== MENU =====
1. Update Profile
2. Update Password
3. Start Exam
4. Logout
Enter choice: 3

===== Exam Started (30 sec) =====

1. Java is _____?
1. Platform-dependent
2. Platform-independent
3. Not a language
4. None
Enter your answer: 2

2. OOP stands for?
1. Object-Oriented Programming
2. Old Operating Program
3. Open Office Program
4. None
Enter your answer: 1

3. Which keyword is used to inherit a class?
1. super
2. this
3. extends
4. import
Enter your answer: 3

4. Java uses which compiler?
1. JIT
2. GCC
3. Turbo
4. None
Enter your answer: 1

5. JVM stands for?
1. Java Very Much
2. Java Virtual Machine
3. Joint Virtual Machine
4. None
Enter your answer: 2

===== Exam Finished =====
Your Score: 5/5

===== MENU =====
1. Update Profile
2. Update Password
3. Start Exam
4. Logout
Enter choice: 4

Logged Out Successfully!

```

## Technologies Used
- Java  
- VS Code  

## Description
This project helps beginners understand:
- OOP in Java  
- Methods  
- Loops & Conditions  
- Timer using Threads  
- User input handling with Scanner 
