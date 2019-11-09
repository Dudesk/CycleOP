# CycleOP

CycleOP is the main tool developped by Dudesk organization.
The goal is to regroup many java libraries into one project.

## TheiaUI

TheiaUI is a java library to create advanced user-interface objects.

### Example

A steps dialog with only one step called "named" that allow to write in a name and a description fields.

```java
// Create a step dialog with a generic name and en empty parent
final StepDialog dialog = new StepDialog("Step dialog", null);

// Add a «Naming» step to the step dialog
dialog.addStep(new NamingStepPanel());

// Show the dialog
dialog.setVisible(true);
```

![](theiaExample.png)
