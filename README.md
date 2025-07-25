# x-mart-grocery-web-app
---
# 1. Project Structures (In Development)
# 1.1 Web (Next.js)
```
web/
├── public/                # static assets
├── src/
│   ├── pages/             # Next.js pages or CRA entry points
│   │   ├── index.tsx
│   │   └── dashboard.tsx
│   ├── features/          # feature modules mirroring pages
│   │   └── dashboard/
│   │       ├── components/  # UI pieces unique to dashboard
│   │       ├── hooks/       # custom hooks for dashboard data
│   │       ├── services/    # API calls (e.g., dashboard.api.ts)
│   │       ├── types.ts
│   │       └── dashboard.module.tsx  # top‑level component
│   ├── components/        # shared, reusable UI components
│   ├── hooks/             # shared hooks (e.g. useAuth, useFetch)
│   ├── lib/               # generic utilities (formatDate, debounce)
│   ├── context/           # React contexts & providers
│   ├── styles/            # globals, themes, Tailwind config
│   └── app.tsx            # root app (if CRA) or custom App (Next.js)
├── .env.local
├── package.json
└── tsconfig.json
```
# 1.2 API (Nest.js)
```
api/
├── src/
│   ├── config/             # environment, constants, logger
│   ├── modules/            # feature‑based folders
│   │   └── auth/           # e.g. authentication feature
│   │       ├── auth.controller.ts
│   │       ├── auth.service.ts
│   │       ├── auth.router.ts
│   │       └── auth.types.ts
│   ├── middleware/         # Express middleware (e.g. errorHandler, validators)
│   ├── utils/              # general helpers (date formatting, retries, etc.)
│   ├── database/           # ORM setup, migrations, connection
│   ├── app.ts              # Express app setup
│   └── server.ts           # Bootstraps app.ts, starts HTTP server
├── tests/                  # unit / integration tests
│   └── auth/               # mirror of src/modules for test files
├── package.json
└── tsconfig.json
```
