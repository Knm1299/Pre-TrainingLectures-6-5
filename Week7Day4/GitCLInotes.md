**Git, Source control, Git CLI**
 - What is git?
 - Git is a source/version control system that is commonly used for collaboration between developers
    - Key features:
    - Allows for a theoretically unlimited number of devs to contribute to the same project
    - Helps prevent conflicting changes, allows for (relatively)easy consolidation when conflicting changes do occur
    - Works on any platform, through CLI, desktop app, or Website
- **Using Git**
 - Today we will use git via a combination of command line and web browser
 - ***common commands:***
    - creating commits(groups of changes):
        - git status
        - git add
        - git commit
            - -m tack
        - git push
        - git pull

<br>





- **Additional topics:**
    - Forking - no useful example today
        - copying someone's repo onto your account
    - branch management
        - Branch Hygiene:
            - Essentially the process of managing different branches for different tasks
            - Typically the main branch is reserved for big releases
            - individual features can be developed on their own branches, and pulled when they are ready to "go into production"(be pulled into main, and on presumably be deployed as a new version)

            <br>
            
            
        - Commands:    
            - git branch
            - git checkout
                - -b tack
    - pull requests
        - I recommend doing this via web or desktop app
 - ***About pull requests***
    - a pull request is a request to add changes from one branch to another.
    - pull requests are easy to create and manage in the web app, not so much via CLI

 - **More resources:**
    - <a href="https://git-scm.com/doc">Git official docs(same as man pages)</a>