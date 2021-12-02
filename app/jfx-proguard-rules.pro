-dontoptimize
-dontshrink

# Before Java 9, the runtime classes were packaged in a single jar file.
#-libraryjars <java.home>/lib/rt.jar

# As of Java 9, the runtime classes are packaged in modular jmod files.
-libraryjars <java.home>/jmods/java.base.jmod(!**.jar;!module-info.class)

# Save meta-data for stack traces
-printmapping out.map
-renamesourcefileattribute SourceFile
-keepattributes SourceFile,LineNumberTable

# Rename FXML files together with related views
-adaptresourcefilenames **.fxml,**.png,**.css,**.properties
-adaptresourcefilecontents **.fxml
-adaptclassstrings

# Keep all annotations and meta-data
-keepattributes *Annotation*,Signature,EnclosingMethod

# Keep names of fields marked with @FXML, @Inject and @PostConstruct attributes
-keepclassmembers class * {
  @javafx.fxml.FXML *;
  @javax.inject.Inject *;
  @javax.annotation.PostConstruct *;
}