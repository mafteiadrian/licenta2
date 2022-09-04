package com.maftei.licenta.service;

import com.maftei.licenta.domain.Material;
import java.util.List;

public interface MaterialService {

	public abstract long countAllMaterials();


	public abstract void deleteMaterial(Material material);


	public abstract Material findMaterial(Long id);


	public abstract List<Material> findAllMaterials();


	public abstract List<Material> findMaterialEntries(int firstResult, int maxResults);


	public abstract void saveMaterial(Material material);


	public abstract Material updateMaterial(Material material);

}
