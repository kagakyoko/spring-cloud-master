package com.pass.cloud.config.properties;

import java.io.Serializable;

import lombok.Getter;

/**
 * @author takesi
 */
@Getter
public class SwaggerProperties implements Serializable {

    private static final long serialVersionUID = 3319698607712846427L;

    private static final String DEFAULT_VERSION = "1.0";

    private String title;

    private String description;

    private String version = DEFAULT_VERSION;

    private String license = "Apache License 2.0";

    private String licenseUrl = "http://www.apache.org/licenses/LICENSE-2.0";

    private String contactName;

    private String contactUrl;

    private String contactEmail;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public void setLicenseUrl(String licenseUrl) {
        this.licenseUrl = licenseUrl;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public void setContactUrl(String contactUrl) {
        this.contactUrl = contactUrl;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }
}
