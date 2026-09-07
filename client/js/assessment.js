/* SkillBridge Warm Signal assessment layer: six-question demo baseline with local results storage. */

document.addEventListener("DOMContentLoaded", () => {
  if (!SkillBridge.guardPortalPage()) return;
  const questions = [
    { category: "Programming", question: "How comfortable are you building a small feature from a written brief?", options: ["I need step-by-step guidance", "I can adapt an example", "I can build it with some research", "I can design and ship it confidently"], answer: 2 },
    { category: "Data Structures", question: "When would you choose a hash map over a list?", options: ["When order is the only priority", "When fast key-based lookup matters", "When storing only images", "When the dataset is always empty"], answer: 1 },
    { category: "Database", question: "What does a database index primarily help with?", options: ["Faster queries on selected columns", "Changing a password", "Styling a dashboard", "Compressing a video"], answer: 0 },
    { category: "Web Development", question: "Which practice best supports an accessible web interface?", options: ["Using images for all text", "Hiding focus states", "Semantic HTML and keyboard support", "Disabling browser zoom"], answer: 2 },
    { category: "Communication", question: "How do you usually share progress on a team project?", options: ["Wait until the deadline", "Share concise updates and blockers", "Only send screenshots", "Avoid documenting decisions"], answer: 1 },
    { category: "Problem Solving", question: "When a solution is not working, what is the strongest first move?", options: ["Change many things at once", "Ignore the error", "Reproduce, isolate, and test one hypothesis", "Start over without notes"], answer: 2 }
  ];
  let current = 0;
  const selections = Array(questions.length).fill(null);
  const questionView = document.querySelector("#question-view");
  const resultView = document.querySelector("#result-view");
  const progress = document.querySelector("[data-assessment-progress]");
  const counter = document.querySelector("[data-question-counter]");
  const backButton = document.querySelector("[data-prev]");
  const nextButton = document.querySelector("[data-next]");

  function renderQuestion() {
    const item = questions[current];
    counter.textContent = `Question ${current + 1} of ${questions.length}`;
    progress.style.width = `${((current + 1) / questions.length) * 100}%`;
    questionView.innerHTML = `<p class="eyebrow">${item.category}</p><h2>${item.question}</h2><div class="option-list">${item.options.map((option, index) => `<label class="option ${selections[current] === index ? "selected" : ""}"><input type="radio" name="assessment-option" value="${index}" ${selections[current] === index ? "checked" : ""}>${option}</label>`).join("")}</div>`;
    questionView.querySelectorAll(".option").forEach((option) => option.addEventListener("click", () => {
      const input = option.querySelector("input");
      selections[current] = Number(input.value);
      questionView.querySelectorAll(".option").forEach((other) => other.classList.remove("selected"));
      option.classList.add("selected");
      nextButton.textContent = current === questions.length - 1 ? "See results ↗" : "Next question ↗";
    }));
    backButton.disabled = current === 0;
    backButton.style.opacity = current === 0 ? ".45" : "1";
    nextButton.textContent = current === questions.length - 1 ? "See results ↗" : "Next question ↗";
  }

  backButton.addEventListener("click", () => { if (current > 0) { current -= 1; renderQuestion(); } });
  nextButton.addEventListener("click", () => {
    if (selections[current] === null) { SkillBridge.showToast("Choose an option before continuing."); return; }
    if (current < questions.length - 1) { current += 1; renderQuestion(); return; }
    const score = Math.round(selections.reduce((total, value, index) => total + (value === questions[index].answer ? 1 : .65), 0) / questions.length * 100);
    SkillBridge.setStored(SkillBridge.STORAGE_KEYS.assessment, { score, completedAt: new Date().toISOString() });
    showResults(score);
  });

  function showResults(score) {
    questionView.parentElement.hidden = true;
    resultView.hidden = false;
    document.querySelector("[data-result-score]").textContent = `${score}%`;
    document.querySelector("[data-result-message]").textContent = score >= 80 ? "You have a strong baseline. Now focus on the gaps that will unlock the next role." : "You have a useful starting point. A focused learning loop can move this signal quickly.";
    document.querySelectorAll("[data-result-bar]").forEach((bar, index) => { bar.style.width = `${[82, 68, 90, 78][index]}%`; });
  }

  document.querySelector("[data-view-map]").addEventListener("click", () => { window.location.href = "skill-map.html"; });
  renderQuestion();
});
