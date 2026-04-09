# Assingment 2

Student Name: Tamerlan Iskakov
Group: IT-2504

Part 1: Logical Data Structures

Task 1 & 2: Account Management & Operations

Data Structure: LinkedList<BankAccount>

Functionality: Supports adding new accounts, searching by username, and performing deposit/withdraw operations that update the balance directly in the list.
<img width="1920" height="1040" alt="image" src="https://github.com/user-attachments/assets/106ee621-ee2b-4c46-89ec-157cd3819042" />
<img width="1920" height="1040" alt="image" src="https://github.com/user-attachments/assets/e26342db-d767-4834-9e0d-a6d00192690a" />


Task 3: Transaction History (LIFO)

Data Structure: Stack<String>.

Functionality: Every deposit or withdrawal is pushed onto the stack. The "Undo" feature uses pop() to remove the last action, and "Peek" displays the most recent transaction.
<img width="1920" height="1040" alt="image" src="https://github.com/user-attachments/assets/ce9e3d2d-95a1-44d0-b823-2e57fd75e5d6" />



Task 4 & 5: Bill Payment & Account Opening (FIFO)

Data Structure: Queue<String> and Queue<BankAccount> using LinkedList implementation.

Functionality: Processes requests in the order they were received. Admin simulation moves account requests from the queue to the main account list upon processing.
<img width="1920" height="1040" alt="image" src="https://github.com/user-attachments/assets/e910d4b6-0947-4dc2-b634-f1311956235d" />
<img width="1920" height="1040" alt="image" src="https://github.com/user-attachments/assets/fd4dc86c-2f81-4fd3-b9b2-44a09306b0ae" />



Part 2: Physical Data Structures

Task 6: Predefined Storage

Data Structure: BankAccount[3] (Array).
Functionality: Demonstrates memory allocation for a fixed number of elements, storing three initial accounts as the system starts.
<img width="1920" height="1040" alt="image" src="https://github.com/user-attachments/assets/b10ea546-750d-4eec-aa33-6a291bec1651" />



Part 3: Mini Banking Menu

The application is integrated into a multi-level menu system:

1.Bank Menu: Submit account requests and perform basic transactions.

2.ATM Menu: Balance inquiries and withdrawals.

3.Admin Area: Manage queues, view history, and perform administrative searches.

<img width="1920" height="1040" alt="image" src="https://github.com/user-attachments/assets/9d5ce529-9543-42dd-86cb-933b89fe7773" />


Work Process

1.Design: Created the BankAccount class to encapsulate account data.

2.Development: Implemented specialized methods for each data structure (Push/Pop for Stack, Add/Poll for Queues).

3.Integration: Built a nested switch-case loop to handle the user interface.

Challenges & Solutions

Issue: String comparisons using == failed to find existing usernames.

Solution: Refactored code to use .equalsIgnoreCase() for reliable object content comparison.


Issue: Input buffer errors when switching between nextInt() and nextLine().

Solution: Added extra scanner.nextLine() calls to consume leftover newline characters and prevent the program from skipping inputs.
