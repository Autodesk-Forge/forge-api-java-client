package com.autodesk.client.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.util.Arrays;
import org.junit.Test;

/**
 * Covers the SVF/SVF2 "advanced" translation-job payload classes added for
 * https://github.com/Autodesk-Forge/forge-api-java-client/issues/55, and the removal of the
 * invalid {@code switchLoader} field from {@link JobObjOutputPayloadAdvanced} for
 * https://github.com/Autodesk-Forge/forge-api-java-client/issues/56.
 */
public class JobSvfOutputPayloadAdvancedTest {

  // Matches the ObjectMapper configuration ApiClient uses for real requests (enums serialize via
  // their wire-value toString(), not their Java constant name).
  private final ObjectMapper mapper = new ObjectMapper()
      .enable(SerializationFeature.WRITE_ENUMS_USING_TO_STRING);

  @Test
  public void svfRvtAdvanced_serializesDocumentedFieldNames() throws Exception {
    JobSvfOutputPayloadAdvancedRVT advanced = new JobSvfOutputPayloadAdvancedRVT()
        .twoDViews(JobSvfOutputPayloadAdvancedRVT.TwoDViewsEnum.PDF)
        .extractorVersion(JobSvfOutputPayloadAdvancedRVT.ExtractorVersionEnum.NEXT)
        .generateMasterViews(true)
        .materialMode(JobSvfOutputPayloadAdvancedRVT.MaterialModeEnum.AUTODESK);

    JsonNode json = mapper.readTree(mapper.writeValueAsString(advanced));

    assertEquals("pdf", json.get("2dviews").asText());
    assertEquals("next", json.get("extractorVersion").asText());
    assertTrue(json.get("generateMasterViews").asBoolean());
    assertEquals("autodesk", json.get("materialMode").asText());
  }

  @Test
  public void svf2IfcAdvanced_serializesDocumentedFieldNames() throws Exception {
    JobSvf2OutputPayloadAdvancedIFC advanced = new JobSvf2OutputPayloadAdvancedIFC()
        .conversionMethod(JobSvf2OutputPayloadAdvancedIFC.ConversionMethodEnum.V4)
        .buildingStoreys(JobSvf2OutputPayloadAdvancedIFC.BuildingStoreysEnum.SHOW)
        .spaces(JobSvf2OutputPayloadAdvancedIFC.SpacesEnum.HIDE)
        .openingElements(JobSvf2OutputPayloadAdvancedIFC.OpeningElementsEnum.SKIP);

    JsonNode json = mapper.readTree(mapper.writeValueAsString(advanced));

    assertEquals("v4", json.get("conversionMethod").asText());
    assertEquals("show", json.get("buildingStoreys").asText());
    assertEquals("hide", json.get("spaces").asText());
    assertEquals("skip", json.get("openingElements").asText());
  }

  @Test
  public void svfDgnAdvanced_serializesLinkageIdArray() throws Exception {
    JobSvfOutputPayloadAdvancedDGN advanced = new JobSvfOutputPayloadAdvancedDGN()
        .requestedLinkageIDs(Arrays.asList(1, 2, 3));

    JsonNode json = mapper.readTree(mapper.writeValueAsString(advanced));

    assertEquals(3, json.get("requestedLinkageIDs").size());
    assertEquals(2, json.get("requestedLinkageIDs").get(1).asInt());
  }

  @Test
  public void svfNwdAdvanced_serializesAllBooleanFlags() throws Exception {
    JobSvfOutputPayloadAdvancedNWD advanced = new JobSvfOutputPayloadAdvancedNWD()
        .hiddenObjects(true)
        .basicMaterialProperties(false)
        .autodeskMaterialProperties(true)
        .timelinerProperties(false);

    JsonNode json = mapper.readTree(mapper.writeValueAsString(advanced));

    assertTrue(json.get("hiddenObjects").asBoolean());
    assertFalse(json.get("basicMaterialProperties").asBoolean());
    assertTrue(json.get("autodeskMaterialProperties").asBoolean());
    assertFalse(json.get("timelinerProperties").asBoolean());
  }

  @Test
  public void svfVueAdvanced_serializesHierarchyEnum() throws Exception {
    JobSvfOutputPayloadAdvancedVUE advanced = new JobSvfOutputPayloadAdvancedVUE()
        .hierarchy(JobSvfOutputPayloadAdvancedVUE.HierarchyEnum.SYSTEM_PATH);

    JsonNode json = mapper.readTree(mapper.writeValueAsString(advanced));

    assertEquals("SystemPath", json.get("hierarchy").asText());
  }

  @Test
  public void objOutputPayloadAdvanced_noLongerSerializesSwitchLoader() throws Exception {
    JobObjOutputPayloadAdvanced advanced = new JobObjOutputPayloadAdvanced()
        .modelGuid("guid-123");

    JsonNode json = mapper.readTree(mapper.writeValueAsString(advanced));

    assertFalse("switchLoader is not a valid OBJ option per the Model Derivative API and must not "
        + "be emitted (issue #56)", json.has("switchLoader"));
  }
}
