package com.myhome.api.util.validation;

import com.myhome.api.util.validation.http.ValidationStatus;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
public class ValidationResult {

	private ValidationStatus status;

	private Set<ValidationResultEntry> infos;
	private Set<ValidationResultEntry> warnings;
	private Set<ValidationResultEntry> errors;

	public boolean isOk() {
		return this.warnings.isEmpty()
				&& this.errors.isEmpty()
				&& this.status != ValidationStatus.WARNING
				&& this.status != ValidationStatus.ERROR;
	}

	public void add(ValidationStatus status, String reason, String... details) {
		if (status == ValidationStatus.INFO)
			this.addInfo(status, reason, details);
		else if (status == ValidationStatus.WARNING)
			this.addWarning(status, reason, details);
		else if (status != ValidationStatus.ERROR)
			throw new IllegalArgumentException("ValidationResult field can only be of type [INFO], [WARNING] or [ERROR]");
		else
			this.addError(status, reason, details);

		this.updateStatus();
	}

	public void add(ValidationResultEntry entry) {
		if (entry.getStatus() == ValidationStatus.INFO)
			this.infos.add(entry);
		else if (entry.getStatus() == ValidationStatus.WARNING)
			this.warnings.add(entry);
		else if (entry.getStatus() != ValidationStatus.ERROR)
			throw new IllegalArgumentException("ValidationResult field can only be of type [INFO], [WARNING] or [ERROR]");
		else
			this.errors.add(entry);

		this.updateStatus();
	}

	private void addInfo(ValidationStatus status, String reason, String... details) {
		this.infos.add(new ValidationResultEntry(status, reason, details));
	}

	private void addWarning(ValidationStatus status, String reason, String... details) {
		this.warnings.add(new ValidationResultEntry(status, reason, details));
	}

	private void addError(ValidationStatus status, String reason, String... details) {
		this.errors.add(new ValidationResultEntry(status, reason, details));
	}

	private void updateStatus() {
		if (this.hasInfos())
			status = ValidationStatus.INFO;
		else if (this.hasWarnings())
			status = ValidationStatus.WARNING;
		else if (this.hasErrors())
			status = ValidationStatus.ERROR;
		else
			status = ValidationStatus.OK;
	}

	private boolean hasInfos() {
		return !this.warnings.isEmpty();
	}

	private boolean hasWarnings() {
		return !this.warnings.isEmpty();
	}

	private boolean hasErrors() {
		return !this.errors.isEmpty();
	}
}
