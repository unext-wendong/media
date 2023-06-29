/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package androidx.media3.exoplayer.dash.manifest;

import androidx.media3.common.C;
import androidx.media3.common.util.UnstableApi;
import java.util.Collections;
import java.util.List;

/** Represents a set of interchangeable encoded versions of a media content component. */
@UnstableApi
public class AdaptationSet {

  /** Value of {@link #id} indicating no value is set.= */
  public static final int ID_UNSET = -1;

  /**
   * An identifier for the adaptation set that's unique in the scope of its containing period, or
   * {@link #ID_UNSET} if not specified.
   *
   * <p>The identifier has the same value as defined in the manifest. However. the manifest value is
   * an unsigned integer and values exceeding {@link Integer#MAX_VALUE} will be represented as
   * negative numbers.
   */
  public final int id;

  /** The {@link C.TrackType track type} of the adaptation set. */
  public final @C.TrackType int type;

  /** {@link Representation}s in the adaptation set. */
  public final List<Representation> representations;

  /** Accessibility descriptors in the adaptation set. */
  public final List<Descriptor> accessibilityDescriptors;

  /** Essential properties in the adaptation set. */
  public final List<Descriptor> essentialProperties;

  /** Supplemental properties in the adaptation set. */
  public final List<Descriptor> supplementalProperties;

  /**
   * @param id A non-negative identifier for the adaptation set that's unique in the scope of its
   *     containing period, or {@link #ID_UNSET} if not specified.
   * @param type The {@link C.TrackType track type} of the adaptation set.
   * @param representations {@link Representation}s in the adaptation set.
   * @param accessibilityDescriptors Accessibility descriptors in the adaptation set.
   * @param essentialProperties Essential properties in the adaptation set.
   * @param supplementalProperties Supplemental properties in the adaptation set.
   */
  public AdaptationSet(
      int id,
      @C.TrackType int type,
      List<Representation> representations,
      List<Descriptor> accessibilityDescriptors,
      List<Descriptor> essentialProperties,
      List<Descriptor> supplementalProperties) {
    this.id = id;
    this.type = type;
    this.representations = Collections.unmodifiableList(representations);
    this.accessibilityDescriptors = Collections.unmodifiableList(accessibilityDescriptors);
    this.essentialProperties = Collections.unmodifiableList(essentialProperties);
    this.supplementalProperties = Collections.unmodifiableList(supplementalProperties);
  }
}
