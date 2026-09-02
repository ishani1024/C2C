# Academia Industry Connect

You are helping me build the FRONTEND of a college-level

Smart India Hackathon project.

PROJECT:

C2C — Academia–Industry Collaboration Portal

SIH PROBLEM STATEMENT:

SIH26044

TITLE:

Portal for Academia - Industry collaboration for Skill Mapping,

Internships and Placement

IMPORTANT:

I am the FRONTEND developer in a 6-member student team.

The project repository already exists and contains:

C2C/

├── backend-java/

├── backend-python/

├── database/

├── frontend/

├── .gitignore

├── README.md

└── docs.md

I am currently working on the Git branch:

feature/frontend

DO NOT modify backend-java, backend-python, database, README.md,

or other team members' work.

Your work must be restricted to the frontend/ directory unless

I explicitly ask otherwise.

==================================================

1. PROJECT PURPOSE

==================================================

The portal is designed to connect:

1. Students

2. Industries

3. Faculty / Academicians

4. Institutions / Administrators

The core purpose is to:

- assess student skills

- identify skill gaps

- map students to relevant career paths

- recommend internships and jobs

- allow students to apply and track opportunities

- allow industries to post opportunities

- allow industries to find suitable candidates

- provide learning and training recommendations

- provide digital student portfolios

- provide faculty opportunities such as FDPs, industrial

  training and research collaboration

- provide institutions with analytics and dashboards

The frontend should communicate this purpose clearly.

==================================================

2. CURRENT DEVELOPMENT STAGE

==================================================

IMPORTANT:

The Java Spring Boot backend is NOT connected yet.

The Python FastAPI AI service is NOT connected yet.

MySQL is NOT connected to the frontend yet.

Therefore:

DO NOT create API calls.

DO NOT create fetch() calls to nonexistent endpoints.

DO NOT create backend code.

DO NOT assume a backend URL.

DO NOT implement real authentication.

DO NOT implement real AI.

DO NOT implement real database functionality.

For now, create a polished frontend prototype using local

mock data.

The architecture should make it easy to replace mock data

with REST API responses later.

==================================================

3. TECHNOLOGY REQUIREMENTS

==================================================

Use:

HTML

CSS

JavaScript

Do NOT introduce React, Angular, Vue, Next.js, Tailwind,

Bootstrap, or another frontend framework unless I explicitly

ask for it.

Keep the frontend understandable for undergraduate students.

Use modular, clean and maintainable HTML/CSS/JavaScript.

Use separate CSS and JavaScript files rather than putting

everything into one enormous HTML file.

==================================================

4. DESIGN DIRECTION

==================================================

The website should look like a modern professional

education + career platform.

The visual identity should communicate:

- academia

- industry

- skills

- career development

- technology

- collaboration

Design should be:

- modern

- clean

- professional

- trustworthy

- slightly futuristic

- student-friendly

- responsive

- suitable for an SIH prototype/demo

Avoid:

- childish designs

- excessive gradients

- excessive animations

- overly bright colors

- clutter

- unnecessary glassmorphism everywhere

- huge decorative elements that reduce usability

Use a consistent design system.

Define CSS variables for:

- primary color

- secondary color

- background

- surface

- text

- muted text

- success

- warning

- danger

- border

- shadow

- border-radius

Use one consistent typography system.

==================================================

5. RESPONSIVENESS

==================================================

The frontend must work on:

- desktop

- laptop

- tablet

- mobile

Use responsive CSS.

Do not create a desktop-only interface.

Dashboards should use responsive grids.

Navigation should adapt to smaller screens.

==================================================

6. FRONTEND FOLDER STRUCTURE

==================================================

First inspect the existing frontend/ directory.

Do not blindly overwrite existing files.

If the directory is empty, create a structure similar to:

frontend/

│

├── index.html

│

├── pages/

│   ├── login.html

│   ├── register.html

│   ├── role-selection.html

│   │

│   ├── student/

│   │   ├── dashboard.html

│   │   ├── skills.html

│   │   ├── assessment.html

│   │   ├── skill-gaps.html

│   │   ├── opportunities.html

│   │   ├── applications.html

│   │   └── portfolio.html

│   │

│   ├── industry/

│   │   ├── dashboard.html

│   │   ├── post-opportunity.html

│   │   ├── opportunities.html

│   │   └── candidates.html

│   │

│   ├── faculty/

│   │   └── dashboard.html

│   │

│   └── admin/

│       └── dashboard.html

│

├── css/

│   ├── style.css

│   ├── components.css

│   ├── auth.css

│   └── dashboard.css

│

├── js/

│   ├── main.js

│   ├── auth.js

│   ├── student.js

│   ├── industry.js

│   └── mock-data.js

│

└── assets/

    ├── images/

    └── icons/

However, if a different structure already exists, preserve it

and improve it instead of unnecessarily restructuring the project.

==================================================

7. LANDING PAGE

==================================================

Create a polished landing page.

The landing page should immediately communicate:

"One platform connecting students, academia and industry."

Suggested structure:

NAVBAR

Logo:

C2C

Navigation:

Home

How It Works

Features

For Students

For Industry

For Academia

Buttons:

Login

Get Started

-----------------------------------

HERO SECTION

Headline:

"Bridge the Gap Between Academia and Industry"

Supporting text explaining that C2C helps students discover

skills, identify skill gaps, find relevant internships/jobs,

and connect with industry.

Primary CTA:

"Get Started"

Secondary CTA:

"Explore Opportunities"

Include a visual representation of the ecosystem:

Students ↔ C2C ↔ Industry

              ↕

           Academia

Do not use a random stock image.

Prefer a clean CSS-based visual, illustration placeholder,

or simple dashboard-style visual.

-----------------------------------

HOW IT WORKS

Show 4 steps:

1. Assess

2. Map

3. Learn

4. Connect

Example:

Assess your skills

↓

Identify skill gaps

↓

Get personalized recommendations

↓

Apply to relevant opportunities

-----------------------------------

CORE FEATURES

Create feature cards for:

Skill Assessment

Skill Mapping

Skill Gap Analysis

Internships & Jobs

Industry Learning

Digital Portfolio

Faculty Opportunities

Analytics

-----------------------------------

WHO IS IT FOR?

Three/four sections:

Students

Industries

Academicians

Institutions

Each should explain the value of the platform.

-----------------------------------

CALL TO ACTION

"Ready to bridge the academia-industry gap?"

Button:

Get Started

-----------------------------------

FOOTER

C2C

Short description

Quick links

Contact placeholder

Copyright

==================================================

8. LOGIN PAGE

==================================================

Create a professional login page.

Fields:

Email

Password

Options:

Remember me

Forgot password

Button:

Login

Also include:

"Don't have an account? Register"

For now, login should NOT contact a backend.

Use mock frontend behavior only.

For demo purposes, allow the user to select a role or

redirect to the role-selection page.

DO NOT implement fake security.

Clearly structure the code so real authentication can be

connected later.

==================================================

9. REGISTRATION PAGE

==================================================

Create registration UI.

Fields:

Full Name

Email

Password

Confirm Password

Role:

Student

Industry

Faculty

Institution Admin

Additional fields should change depending on the selected role.

For example:

Student:

- Institution

- Course

- Year

Industry:

- Company Name

- Industry Type

Faculty:

- Institution

- Department

- Designation

Admin:

- Institution

Do frontend validation:

- required fields

- valid email

- password confirmation

- basic input validation

Do NOT create backend registration.

==================================================

10. ROLE SELECTION

==================================================

Create a visually appealing role-selection page.

Heading:

"How will you use C2C?"

Four cards:

STUDENT

Assess skills

Find opportunities

Build portfolio

INDUSTRY

Post opportunities

Find candidates

Connect with students

FACULTY

Find FDPs

Industrial training

Research collaboration

INSTITUTION

Monitor skills

Track internships

Analyze placements

Each card should have:

- icon

- title

- description

- Continue button

For now, clicking a role can route to the appropriate

mock dashboard.

==================================================

11. STUDENT DASHBOARD

==================================================

This is the MOST IMPORTANT page for the current phase.

Create a polished student dashboard.

Layout:

SIDEBAR

C2C logo

Overview

My Profile

My Skills

Skill Assessment

Skill Gaps

Opportunities

Applications

Portfolio

Bottom:

Settings

Logout

TOP BAR

Search

Notifications icon

Student profile/avatar

Main content:

-----------------------------------

WELCOME SECTION

"Good morning, Alex"

"Here's your career readiness overview."

-----------------------------------

PROFILE COMPLETION

Example:

Profile completion

78%

Progress bar

Button:

Complete Profile

-----------------------------------

SKILL OVERVIEW

Show skill cards:

Java

Python

SQL

Communication

Problem Solving

Each can show a proficiency value using a clean progress

indicator.

Use mock values.

Do not imply these are real user scores.

-----------------------------------

CAREER READINESS

Create a clean visual showing:

Technical Skills

Soft Skills

Projects

Certifications

Use a mock readiness score.

Example:

Career Readiness

74%

Clearly structure this as mock/demo data.

-----------------------------------

SKILL GAPS

Show 2–3 example skill gaps.

Example:

Data Structures

Current: Intermediate

Target: Advanced

SQL

Current: Beginner

Target: Intermediate

Show:

"Recommended learning"

button.

-----------------------------------

RECOMMENDED OPPORTUNITIES

Create opportunity cards.

Each should include:

Company

Role

Type

Location

Required skills

Match percentage

Deadline

Apply button

Example:

Software Development Intern

TechNova

Remote

Java • Spring Boot • SQL

86% Match

Use mock data.

-----------------------------------

RECENT APPLICATIONS

Table/cards:

Opportunity

Company

Applied On

Status

Statuses:

Applied

Under Review

Shortlisted

Rejected

Use visually distinct status badges.

-----------------------------------

QUICK ACTIONS

Buttons:

Take Skill Assessment

Update Skills

Explore Internships

View Portfolio

==================================================

12. STUDENT SKILLS PAGE

==================================================

Create a dedicated "My Skills" page.

Sections:

My Technical Skills

My Soft Skills

Certifications

Projects

Allow mock UI for:

Add Skill

Edit Skill

Remove Skill

Skill cards should contain:

Skill name

Category

Proficiency

Last assessed

Example:

Java

Technical

Intermediate

Assessed recently

Do not persist to a database yet.

==================================================

13. SKILL ASSESSMENT PAGE

==================================================

Create the UI for a questionnaire.

Include:

Progress indicator

Question number

Question

Multiple-choice options

Previous button

Next button

Submit Assessment

Example categories:

Programming

Database

Problem Solving

Communication

Teamwork

Create around 5–8 mock questions.

Frontend should track the current question using JavaScript.

At the end show a mock results screen.

Example:

Assessment Complete

Technical Skills: 72%

Problem Solving: 81%

Communication: 76%

Do NOT claim this is scientifically accurate.

This is only a prototype.

==================================================

14. SKILL GAP PAGE

==================================================

Create:

"Your Skill Gap Analysis"

Show:

Current Skills

Target Career Role

Missing Skills

Recommended Learning

Example:

Target Role:

Backend Developer

Required:

Java

Spring Boot

SQL

REST APIs

Git

Current:

Java ✓

SQL ✓

Git ✓

Skill gaps:

Spring Boot

REST APIs

Then show learning recommendations.

Use mock data.

==================================================

15. OPPORTUNITIES PAGE

==================================================

Create a searchable opportunities interface.

Tabs:

All

Internships

Jobs

Projects

Filters:

Location

Skills

Experience

Type

Domain

Opportunity cards should include:

Company

Role

Description

Required skills

Location

Duration

Match percentage

Apply button

Use mock data.

Add client-side filtering/search using JavaScript.

No backend API yet.

==================================================

16. APPLICATIONS PAGE

==================================================

Create an application tracking page.

Use a timeline or status tracker:

Applied

Under Review

Shortlisted

Interview

Selected

Show example applications.

Allow filtering by status.

Again, use mock data.

==================================================

17. PORTFOLIO PAGE

==================================================

Create a student digital portfolio.

Sections:

Profile

About

Skills

Projects

Certifications

Internships

Achievements

Include:

Download Resume

Share Portfolio

buttons as UI placeholders.

Create a visually polished profile header.

==================================================

18. INDUSTRY DASHBOARD

==================================================

Create a basic but polished industry dashboard.

Sidebar:

Overview

Company Profile

Post Opportunity

My Opportunities

Applicants

Candidate Matching

Dashboard cards:

Active Opportunities

Applications

Shortlisted Candidates

Interviews

Include:

Recent applicants

Active internship/job postings

Candidate matching preview

Use mock data.

==================================================

19. INDUSTRY POST OPPORTUNITY PAGE

==================================================

Create a form:

Opportunity Type

Job / Internship / Project

Title

Description

Required Skills

Qualifications

Location

Work Mode

Duration

Stipend placeholder

Application Deadline

Submit Opportunity

Use frontend validation only.

Do not submit to a backend.

==================================================

20. CANDIDATE MATCHING UI

==================================================

Create a UI showing candidates matched to an opportunity.

Example:

Backend Developer Intern

Candidate A

92% Match

Skills:

Java ✓

SQL ✓

Spring Boot ✓

Candidate B

84% Match

Skills:

Java ✓

SQL ✓

Show:

View Profile

Shortlist

These buttons can be non-functional placeholders for now.

==================================================

21. FACULTY DASHBOARD

==================================================

Create a basic faculty dashboard.

Sections:

Faculty Opportunities

Industrial Training

FDPs

Research Collaboration

Mentorship

Show cards for:

FDP

Industrial Training

Research Project

Guest Lecture

Mentorship

Use mock data.

==================================================

22. ADMIN DASHBOARD

==================================================

Create an institution/admin dashboard.

Show:

Total Students

Industry Partners

Active Internships

Placement Rate

Students Assessed

Analytics sections:

Skill Demand

Internship Participation

Placement Readiness

Use simple CSS-based charts or lightweight HTML visualizations.

Do not add chart libraries unless absolutely necessary.

Mock data is acceptable.

==================================================

23. NAVIGATION

==================================================

Implement frontend navigation between pages.

Links should work locally.

Avoid broken links.

Use relative paths correctly.

The sidebar should allow navigation between student pages.

Navbar should allow navigation to:

Home

Login

Register

Role cards should navigate to appropriate dashboards.

==================================================

24. MOCK DATA

==================================================

Create a central:

js/mock-data.js

containing sample data for:

students

skills

opportunities

applications

companies

candidates

faculty opportunities

analytics

Do not duplicate the same data across many files.

Structure the mock data so it can later be replaced with

REST API responses.

==================================================

25. JAVASCRIPT ARCHITECTURE

==================================================

Keep JavaScript modular.

Use functions such as:

renderOpportunities()

filterOpportunities()

renderApplications()

updateAssessment()

calculateMockResults()

renderSkills()

validateForm()

Do not create one 2,000-line JavaScript file.

Use event listeners properly.

Avoid unnecessary global variables.

==================================================

26. ACCESSIBILITY

==================================================

Use:

semantic HTML

labels for form fields

alt text for meaningful images

keyboard-friendly controls

visible focus states

sufficient text contrast

Buttons should actually look like buttons.

Forms should have proper labels.

==================================================

27. UX REQUIREMENTS

==================================================

Include:

loading placeholders where appropriate

empty states

success states

error states

hover states

focus states

But don't over-animate the interface.

Use subtle transitions.

==================================================

28. IMPORTANT BACKEND COMPATIBILITY

==================================================

The future backend will be:

Java 21

Spring Boot

MySQL

AI service:

Python

FastAPI

The frontend will eventually communicate with the Java backend

through REST APIs.

Therefore:

- keep data models logically structured

- don't tightly couple UI components to mock data

- keep API integration easy to add later

- don't hardcode database logic

- don't put API keys in frontend files

- don't put Gemini API keys in JavaScript

- don't expose secrets in the frontend

==================================================

29. SECURITY

==================================================

Do NOT:

- store passwords

- store API keys

- hardcode credentials

- pretend frontend authentication is secure

- implement fake authorization

Frontend validation is only for user experience.

Real authentication will later be handled by Spring Security.

==================================================

30. CODE QUALITY

==================================================

Before modifying anything:

1. Inspect the existing frontend directory.

2. Identify existing files.

3. Preserve useful existing work.

4. Do not overwrite files unnecessarily.

5. Explain what you intend to change.

When implementing:

- use clear names

- use comments only where useful

- avoid duplicate code

- keep functions small

- keep CSS organized

- keep HTML semantic

- keep JavaScript readable

==================================================

31. DEVELOPMENT STRATEGY

==================================================

DO NOT implement everything at once.

Work in stages.

STAGE 1:

Create the frontend foundation:

- index.html

- global CSS

- navigation

- reusable UI components

- mock-data.js

STAGE 2:

Build:

- Landing page

- Login

- Registration

- Role selection

STAGE 3:

Build:

- Student dashboard

- Student skills

- Assessment

- Skill gaps

STAGE 4:

Build:

- Opportunities

- Applications

- Portfolio

STAGE 5:

Build:

- Industry dashboard

- Post opportunity

- Candidate matching

STAGE 6:

Build:

- Faculty dashboard

- Admin dashboard

Do not jump directly to Stage 6.

==================================================

32. VERY IMPORTANT AI CODING RULE

==================================================

You are working inside an existing Git repository.

Before changing files:

INSPECT THE CURRENT PROJECT.

Do not assume files are empty.

Do not delete existing work.

Do not rewrite the whole project.

Do not create duplicate files with slightly different names.

If something already exists, improve/reuse it.

==================================================

33. CURRENT TASK

==================================================

For THIS request, ONLY implement STAGE 1 and STAGE 2.

That means:

1. Inspect frontend/

2. Set up the frontend structure if necessary

3. Create the global design system

4. Create reusable navigation/footer styles

5. Create mock-data.js

6. Build the landing page

7. Build login page

8. Build registration page

9. Build role-selection page

10. Make navigation between these pages work

11. Make everything responsive

12. Test all links and interactions

DO NOT build the student dashboard yet.

DO NOT build the AI system yet.

DO NOT connect APIs yet.

DO NOT touch backend-java.

DO NOT touch backend-python.

DO NOT touch database.

==================================================

34. AFTER IMPLEMENTATION

==================================================

Do NOT just say "done."

Give me a report containing:

1. Files created

2. Files modified

3. Files deleted, if any

4. What each major file does

5. Features implemented

6. Navigation paths

7. Mock data created

8. How to run the frontend locally

9. Any problems encountered

10. Anything that still needs to be done

If you encounter an ambiguity, STOP and explain it before making

a major architectural decision.

Remember:

I am a beginner and this project will be primarily

AI-assisted/vibe-coded.

Prioritize:

CORRECTNESS > maintainability > simplicity > visual polish.

Do not generate unnecessary complexity.

This project was built with [Lovable](https://lovable.dev).

## Build with Lovable

Continue developing this project in the [Lovable editor](https://lovable.dev/projects/a4dae540-7d05-41c1-a108-bb6f9b0c5fef).

- **Ship faster**: describe what you want to build and Lovable handles the code.
- **Stay in sync**: every change made in Lovable is committed straight to this repository.
- **Full ownership**: this code is yours. Push to `main` on GitHub and your changes sync back into Lovable, ready for your next prompt.

## Development

Prefer working locally? You need Node.js and npm — [install with nvm](https://github.com/nvm-sh/nvm#installing-and-updating).

```sh
git clone <this-repository-url>
cd <repository-name>
npm i
npm run dev
```
