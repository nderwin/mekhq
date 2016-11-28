/*
 * MrbcRatingFactory.java
 *
 * Copyright (c) 2009 Jay Lawson <jaylawson39 at yahoo.com>. All rights reserved.
 *
 * This file is part of MekHQ.
 *
 * MekHQ is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * MekHQ is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with MekHQ.  If not, see <http://www.gnu.org/licenses/>.
 */
package mekhq.campaign.rating;

import mekhq.campaign.Campaign;

/**
 * @author Deric Page (deric (dot) page (at) usa.net)
 * @version %I% %G%
 * @since 3/16/2012
 */
public class UnitRatingFactory {

    /**
     * Returns the Dragoons Rating method as selected in the Campaign Options dialog.
     */
    public static IUnitRating getUnitRating(Campaign campaign) {
        UnitRatingMethod method = campaign.getCampaignOptions().getUnitRatingMethod();
        if (method.equals(UnitRatingMethod.FLD_MAN_MERCS_REV)) {
            return new FieldManualMercRevDragoonsRating(campaign);
        }

        return new CampaignOpsReputation(campaign);
    }

}
