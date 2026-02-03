# AI Job Matching Platform

An AI-powered full-stack application that automatically discovers and ranks job opportunities based on a candidate’s resume.

The system connects to the user’s email inbox, extracts job-related emails, analyzes job descriptions using AI/NLP, and calculates a compatibility score for each position.

Only the most relevant jobs are presented — summarized, ranked, and ready to apply.

---

## Tech Stack

Backend:
- Java
- Spring Boot
- REST API
- Maven

Frontend:
- Angular
- TypeScript

AI / Logic:
- Resume parsing
- Keyword extraction
- NLP matching
- Compatibility scoring

Integrations:
- Gmail / IMAP email parsing
- External job links

---

## Features

- Connect to personal email inbox
- Automatically extract job offers from emails
- Upload and analyze resume
- AI-based job matching
- Compatibility score for each job
- Smart job summaries
- Ranked job recommendations
- Direct links to apply

---

## Project Structure

career-matcher/
backend/     -> Spring Boot API  
frontend/    -> Angular client  
ai/          -> matching logic (optional)

---

## Setup

Backend:

cd backend  
mvn clean install  
mvn spring-boot:run  

Frontend:

cd frontend  
npm install  
ng serve  

---

## How It Works

1. User uploads resume
2. System connects to email inbox
3. Extracts job-related emails
4. Parses job descriptions
5. AI analyzes resume
6. Calculates compatibility score
7. Jobs are ranked and displayed

---

## Goal

To simplify and personalize the job search process using AI and automation.

---

## Author

Sara  
Full-Stack Developer | Java | Angular
