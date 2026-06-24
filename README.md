#   SortMetrics Engine

![Build Status](https://img.shields.io/badge/Build-Passing-success?style=for-the-badge&logo=github-actions)
![Coverage](https://img.shields.io/badge/Coverage-100%25-blue?style=for-the-badge)
![License](https://img.shields.io/badge/License-Apache_2.0-red?style=for-the-badge&logo=apache)
![Runtime](https://img.shields.io/badge/JVM-17%2B-orange?style=for-the-badge&logo=java)

###  The Elevator Pitch
**SortMetrics Engine** is a high-precision data processing tool designed to benchmark algorithmic efficiency within the JVM ecosystem. Instead of relying on standard library abstractions, this project implements low-level data sorting patterns combined with nanosecond-resolution metrics to measure the real-world performance overhead of sorting architectures.

---

##  Architecture & Logic Flow

The engine uses a decoupling pattern that separates disk-based data ingestion from in-memory processing and benchmarking loops.

```mermaid
graph TD
    A[External Input: input_names.txt] -->|BufferedReader Stream| B(Data Ingestion Layer)
    B --> C{SortMetrics Core}
    C -->|Bubble Sort Algorithm| D[In-Memory Mutation]
    C -->|System.nanoTime| E[Performance Benchmarking]
    D --> F[Persistence Layer: sorted_results.txt]
    E --> G[Standard Output Logs]



