/* SkillBridge Warm Signal opportunities layer: client-side demo filters ready for future /api/opportunities. */

const opportunities = [
  { title: "Software Development Intern", company: "Example Company", location: "Kolkata / Remote", type: "Internship", mode: "Remote", experience: "Entry level", skills: ["Java", "SQL", "Git"], match: 87 },
  { title: "Junior Data Associate", company: "Example Labs", location: "Remote", type: "Job", mode: "Remote", experience: "Entry level", skills: ["Python", "SQL"], match: 82 },
  { title: "Frontend Engineering Intern", company: "Example Studio", location: "Bengaluru", type: "Internship", mode: "On-site", experience: "Entry level", skills: ["JavaScript", "HTML/CSS", "Git"], match: 79 },
  { title: "Cloud Support Trainee", company: "Example Systems", location: "Hyderabad", type: "Job", mode: "On-site", experience: "Graduate", skills: ["Linux", "Cloud", "Problem solving"], match: 74 }
];

document.addEventListener("DOMContentLoaded", () => {
  if (!SkillBridge.guardPortalPage()) return;
  const list = document.querySelector("[data-opportunity-list]");
  const search = document.querySelector("[data-opportunity-search]");
  const filters = [...document.querySelectorAll("[data-opportunity-filter]")];
  function render() {
    const query = (search.value || "").toLowerCase();
    const values = Object.fromEntries(filters.map((filter) => [filter.dataset.opportunityFilter, filter.value]));
    const filtered = opportunities.filter((item) => {
      const haystack = [item.title, item.company, item.location, item.type, item.mode, item.experience, ...item.skills].join(" ").toLowerCase();
      return (!query || haystack.includes(query)) && (!values.type || item.type === values.type) && (!values.mode || item.mode === values.mode) && (!values.skill || item.skills.includes(values.skill));
    });
    list.innerHTML = filtered.length ? filtered.map((item) => `<article class="opportunity-card"><div><p class="muted-label">${item.type} · ${item.experience}</p><h3>${item.title}</h3><p>${item.company} · ${item.location}</p><div class="chip-row">${item.skills.map((skill) => `<span class="chip">${skill}</span>`).join("")}</div></div><div class="opportunity-aside"><span class="match-badge">${item.match}% match</span><button class="btn btn-primary btn-sm" data-opportunity-apply="${item.title}">View role ↗</button></div></article>`).join("") : `<div class="empty-state"><strong>No close matches yet.</strong>Try clearing a filter or searching a broader skill.</div>`;
    list.querySelectorAll("[data-opportunity-apply]").forEach((button) => button.addEventListener("click", () => SkillBridge.showToast(`${button.dataset.opportunityApply} is a demo listing ready for the future opportunities API.`)));
  }
  search.addEventListener("input", render);
  filters.forEach((filter) => filter.addEventListener("change", render));
  render();
});
