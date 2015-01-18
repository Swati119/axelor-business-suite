/**
 * Axelor Business Solutions
 *
 * Copyright (C) 2014 Axelor (<http://axelor.com>).
 *
 * This program is free software: you can redistribute it and/or  modify
 * it under the terms of the GNU Affero General Public License, version 3,
 * as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.axelor.apps.production.service.config;

import com.axelor.apps.base.db.Company;
import com.axelor.apps.production.db.ProductionConfig;
import com.axelor.apps.production.db.repo.ProductionConfigRepository;
import com.axelor.apps.stock.db.Location;
import com.axelor.exception.AxelorException;
import com.axelor.exception.db.IException;

public class ProductionConfigService extends ProductionConfigRepository {
	
	public ProductionConfig getProductionConfig(Company company) throws AxelorException  {
		
		ProductionConfig productionConfig = company.getProductionConfig(); 
		
		if(productionConfig == null)  {
			throw new AxelorException(String.format("Veuillez configurer la production pour la société %s",
					company.getName()), IException.CONFIGURATION_ERROR);
		}
		
		return productionConfig;
		
	}
	
	
	
	/******************************** LOCATION ********************************************/
	
	public Location getProductionVirtualLocation(ProductionConfig productionConfig) throws AxelorException  {
		
		if(productionConfig.getProductionVirtualLocation() == null)  {
			throw new AxelorException(String.format("Veuillez configurer un Emplacement Virtuel Production pour la société %s",
					productionConfig.getCompany().getName()), IException.CONFIGURATION_ERROR);
		}
		
		return productionConfig.getProductionVirtualLocation();
		
	}
	
	
}
