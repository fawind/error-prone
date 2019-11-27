---
title: ExtendsAutoValue
summary: Do not extend an @AutoValue/@AutoOneOf class in non-generated code.
layout: bugpattern
tags: ''
severity: WARNING
---

<!--
*** AUTO-GENERATED, DO NOT MODIFY ***
To make changes, edit the @BugPattern annotation or the explanation in docs/bugpattern.
-->

## The problem


## Suppression
Suppress false positives by adding the suppression annotation `@SuppressWarnings("ExtendsAutoValue")` to the enclosing element.