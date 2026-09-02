# C2C Frontend (Stage 1 + Stage 2)

Plain HTML / CSS / JavaScript prototype for **SIH26044 — Portal for Academia–Industry
collaboration for Skill Mapping, Internships and Placement**. No frameworks, no build
step, no backend calls.

## Structure

```
frontend/
├── index.html              Landing page
├── pages/
│   ├── login.html          Login (mock, no auth)
│   ├── register.html       Registration with role-specific fields
│   ├── role-selection.html "How will you use C2C?"
│   └── coming-soon.html    Placeholder for dashboards (Stage 3+)
├── css/
│   ├── style.css           Design tokens, base, layout, navbar, hero, footer
│   ├── components.css      Buttons, cards, badges, forms, progress, toasts
│   └── auth.css            Login / register / role-selection layouts
├── js/
│   ├── mock-data.js        Single source of demo data (API-shaped)
│   ├── main.js             Nav toggle, toasts, feature + role card rendering
│   └── auth.js             Form validation and mock login/register flows
└── assets/{images,icons}/  Empty, ready for artwork
```

`css/dashboard.css`, `js/student.js` and `js/industry.js` are intentionally not created
yet — they belong to Stage 3+.

## Run locally

Open `index.html` directly, or serve the folder:

```bash
cd frontend
python3 -m http.server 5500   # then visit http://localhost:5500
```

## Connecting the backend later

- All demo content lives in `js/mock-data.js`; replace each `MockData.x` with a REST
  response from the Spring Boot API.
- Search for `TODO(backend)` in `js/auth.js` for the two auth submit points.
- No secrets, API keys or credentials exist in this folder — keep it that way.
