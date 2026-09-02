/* ============================================================
   C2C — Central mock data (DEMO ONLY)
   ------------------------------------------------------------
   Every object here mirrors the shape we expect from the future
   Spring Boot REST API, so each `MockData.x` can later be swapped
   for `await api.get('/x')` without touching the render code.
   ============================================================ */

const MockData = {
  /* Roles used by login, register and role-selection pages */
  roles: [
    {
      id: "student",
      label: "Student",
      description: "Assess your skills, close gaps and find internships.",
      benefits: ["Assess skills", "Find opportunities", "Build portfolio"],
      dashboard: "student/dashboard.html",
    },
    {
      id: "industry",
      label: "Industry",
      description: "Post opportunities and discover job-ready candidates.",
      benefits: ["Post opportunities", "Find candidates", "Connect with students"],
      dashboard: "industry/dashboard.html",
    },
    {
      id: "faculty",
      label: "Faculty",
      description: "Access FDPs, industrial training and research collaboration.",
      benefits: ["Find FDPs", "Industrial training", "Research collaboration"],
      dashboard: "faculty/dashboard.html",
    },
    {
      id: "admin",
      label: "Institution",
      description: "Track skills, internships and placement readiness.",
      benefits: ["Monitor skills", "Track internships", "Analyse placements"],
      dashboard: "admin/dashboard.html",
    },
  ],

  /* Extra registration fields per role (drives the dynamic form) */
  roleFields: {
    student: [
      { name: "institution", label: "Institution", type: "text", placeholder: "e.g. Govt. Engineering College" },
      { name: "course", label: "Course", type: "text", placeholder: "e.g. B.Tech Computer Science" },
      {
        name: "year", label: "Year of study", type: "select",
        options: ["1st Year", "2nd Year", "3rd Year", "4th Year"],
      },
    ],
    industry: [
      { name: "companyName", label: "Company name", type: "text", placeholder: "e.g. TechNova Solutions" },
      {
        name: "industryType", label: "Industry type", type: "select",
        options: ["IT & Software", "Manufacturing", "Finance", "Healthcare", "Energy", "Other"],
      },
    ],
    faculty: [
      { name: "institution", label: "Institution", type: "text", placeholder: "e.g. NIT Rourkela" },
      { name: "department", label: "Department", type: "text", placeholder: "e.g. Computer Science" },
      {
        name: "designation", label: "Designation", type: "select",
        options: ["Assistant Professor", "Associate Professor", "Professor", "Lecturer"],
      },
    ],
    admin: [
      { name: "institution", label: "Institution", type: "text", placeholder: "e.g. University of Delhi" },
      { name: "designation", label: "Designation", type: "text", placeholder: "e.g. Placement Officer" },
    ],
  },

  /* Demo students */
  students: [
    {
      id: "STU-1001",
      name: "Alex Menon",
      email: "alex.menon@example.edu",
      institution: "Govt. Engineering College",
      course: "B.Tech Computer Science",
      year: "3rd Year",
      profileCompletion: 78,
      careerReadiness: 74,
      targetRole: "Backend Developer",
    },
  ],

  /* Skills catalogue */
  skills: [
    { id: "SK-1", name: "Java", category: "Technical", proficiency: 72, level: "Intermediate", lastAssessed: "2026-08-12" },
    { id: "SK-2", name: "Python", category: "Technical", proficiency: 65, level: "Intermediate", lastAssessed: "2026-08-10" },
    { id: "SK-3", name: "SQL", category: "Technical", proficiency: 48, level: "Beginner", lastAssessed: "2026-07-28" },
    { id: "SK-4", name: "Communication", category: "Soft", proficiency: 76, level: "Intermediate", lastAssessed: "2026-08-01" },
    { id: "SK-5", name: "Problem Solving", category: "Soft", proficiency: 81, level: "Advanced", lastAssessed: "2026-08-05" },
  ],

  /* Skill gaps against the target career role */
  skillGaps: [
    { skill: "Data Structures", current: "Intermediate", target: "Advanced", priority: "High" },
    { skill: "SQL", current: "Beginner", target: "Intermediate", priority: "High" },
    { skill: "Spring Boot", current: "None", target: "Intermediate", priority: "Medium" },
  ],

  /* Companies */
  companies: [
    { id: "CMP-1", name: "TechNova Solutions", industryType: "IT & Software", location: "Bengaluru" },
    { id: "CMP-2", name: "GridWorks Energy", industryType: "Energy", location: "Pune" },
    { id: "CMP-3", name: "FinEdge Labs", industryType: "Finance", location: "Remote" },
  ],

  /* Opportunities (internships / jobs / projects) */
  opportunities: [
    {
      id: "OPP-1", title: "Software Development Intern", company: "TechNova Solutions",
      type: "Internship", mode: "Remote", location: "Remote", duration: "6 months",
      stipend: "₹20,000 / month", skills: ["Java", "Spring Boot", "SQL"],
      match: 86, deadline: "2026-09-30", domain: "Software",
      description: "Work with the backend team on REST APIs and database design.",
    },
    {
      id: "OPP-2", title: "Data Analyst Intern", company: "FinEdge Labs",
      type: "Internship", mode: "Hybrid", location: "Mumbai", duration: "3 months",
      stipend: "₹15,000 / month", skills: ["Python", "SQL", "Excel"],
      match: 74, deadline: "2026-10-10", domain: "Data",
      description: "Support dashboards and reporting for the analytics team.",
    },
    {
      id: "OPP-3", title: "Junior Backend Engineer", company: "GridWorks Energy",
      type: "Job", mode: "On-site", location: "Pune", duration: "Full-time",
      stipend: "₹6.5 LPA", skills: ["Java", "REST APIs", "MySQL"],
      match: 68, deadline: "2026-10-22", domain: "Software",
      description: "Build services for energy monitoring platforms.",
    },
  ],

  /* Applications */
  applications: [
    { id: "APP-1", opportunity: "Software Development Intern", company: "TechNova Solutions", appliedOn: "2026-08-18", status: "Under Review" },
    { id: "APP-2", opportunity: "Data Analyst Intern", company: "FinEdge Labs", appliedOn: "2026-08-11", status: "Shortlisted" },
    { id: "APP-3", opportunity: "Junior Backend Engineer", company: "GridWorks Energy", appliedOn: "2026-07-30", status: "Rejected" },
  ],

  /* Candidates matched to an industry opportunity */
  candidates: [
    { id: "CAN-1", name: "Candidate A", match: 92, institution: "IIT Bhubaneswar", skills: ["Java", "SQL", "Spring Boot"] },
    { id: "CAN-2", name: "Candidate B", match: 84, institution: "Govt. Engineering College", skills: ["Java", "SQL"] },
  ],

  /* Faculty opportunities */
  facultyOpportunities: [
    { id: "FAC-1", title: "AI in Education FDP", type: "FDP", host: "TechNova Academy", mode: "Online", duration: "2 weeks" },
    { id: "FAC-2", title: "Industrial Training: Cloud Systems", type: "Industrial Training", host: "GridWorks Energy", mode: "On-site", duration: "1 month" },
    { id: "FAC-3", title: "Smart Grid Research Collaboration", type: "Research", host: "GridWorks Energy", mode: "Hybrid", duration: "6 months" },
  ],

  /* Institution analytics */
  analytics: {
    totalStudents: 2450,
    industryPartners: 68,
    activeInternships: 312,
    placementRate: 74,
    studentsAssessed: 1890,
    skillDemand: [
      { skill: "Java", demand: 82 },
      { skill: "Python", demand: 78 },
      { skill: "SQL", demand: 65 },
      { skill: "Cloud", demand: 54 },
      { skill: "Communication", demand: 49 },
    ],
  },

  /* Landing page content */
  features: [
    { title: "Skill Assessment", text: "Structured questionnaires that capture technical and soft skills." },
    { title: "Skill Mapping", text: "Map assessed skills to career paths and industry roles." },
    { title: "Skill Gap Analysis", text: "See exactly which skills stand between you and your target role." },
    { title: "Internships & Jobs", text: "Discover opportunities ranked by how well they match your profile." },
    { title: "Industry Learning", text: "Curated learning and training paths recommended by industry." },
    { title: "Digital Portfolio", text: "A shareable profile with projects, certifications and internships." },
    { title: "Faculty Opportunities", text: "FDPs, industrial training and research collaboration in one place." },
    { title: "Analytics", text: "Institution dashboards for skills, internships and placement readiness." },
  ],
};

/* Expose globally (no bundler in this prototype) */
window.MockData = MockData;
