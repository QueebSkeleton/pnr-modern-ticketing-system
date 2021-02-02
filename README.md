# Philippine National Railways - Modern Ticketing System

A modern ticketing solution for the Philippine National Railways. Especially during the pandemic, the aforementioned railway system needs
a better mechanism for ticketing, proposing not only faster throughput and efficiency, but also contactless transactions through the use of machines.

This is only a simulation project intended to deliver the minimal and fundamental features, as a final requirement in
Modeling and Simulation, a subject in the Computer Science curriculum of the Polytechnic University of the Philippines.

### Features
1. **Administrator Module**  
    - Login
    - Station Management Panel
    - Account Management Panel (for Cashier, Administrator accounts)
    - Machine Management Panel
    - Sales Monitoring Panel (all tickets sold are shown here)
    - Passenger Density Monitoring Panel
1. **Cashier Module**
    - Login
    - Ticket Error-Handling
    - Manual Ticket Selling Panel
1. **Machine Module**
    - Authentication (for Setting Up), Prompts for Machine ID and Password
    - Ticket Ordering Panel

### Technical Specifications
1. Java, Runtime Environment ver. 15
1. MySQL Server ver. 8.0.23

### Running the Project
1. Create a **runnable JAR** out of the project, specifying `Main-class` attribute of the manifest file to `co.sympu.pnrticketing.PnrModernTicketingApplication.java`,
also including `mysql-connector-j-8.0.23.jar` inside the JAR as well, or somewhere it can be found when you run it later.
2. (You must have an instance of MySQL Server on your local machine) Execute `database.sql` under `src/main/resources` in your local MySQL Server.
3. Run the JAR file, assuming that the name of the JAR is in the following command:
`java -jar PnrModernTicketingApplication.jar`
If you didn't include `mysql-connector-j-8.0.23.jar` inside the JAR, you have to specify it in the runtime classpath.

---
## For Developers

### Toolset to Use
1. Java, Development Kit ver. 15
1. MySQL Server ver. 8.0.23
1. MySQL Command-Line Client ver. 8.0.23
1. MySQL Workbench Client ver. 8.0.23
1. Eclipse R 2020-12, Java Developers Edition
1. MySQL Connector/J (should've included this on the project itself) ver. 8.0.23
1. Git (either manual Git or eGit - Git for Eclipse)

### Implementing your own feature
**NOTE**: Since we're not open-source software, we won't use fork.

`main` branch contains official verified commits.

1. Clone this repository to your local development machine.
    ```
    git clone https://github.com/QueebSkeleton/pnr-modern-ticketing-system.git
    ```

1. Create your own branch.
    ```
    git checkout main
    git branch feature-whatever-branch
    ```

1. Implement your features, and then commit them with proper messages.
    ```
    git add -A
    git commit -m "Implement JFrame"
    ```
    
1. When you either want your code reviewed or you're done, push your branch to this GitHub repository.
This repository must be both your upstream and downstream repository. Assuming remote branch is named origin.
    ```
    git push origin feature-whatever-branch
    ```
    
1. When you are done with your feature and you want your branch to be merged to our `main` branch, create a
pull request for the SCRUM Master to review.
