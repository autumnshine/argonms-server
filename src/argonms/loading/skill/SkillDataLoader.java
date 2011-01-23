/*
 * ArgonMS MapleStory server emulator written in Java
 * Copyright (C) 2011  GoldenKevin
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package argonms.loading.skill;

import argonms.loading.DataFileType;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author GoldenKevin
 */
public abstract class SkillDataLoader {
	private static SkillDataLoader instance;

	protected Map<Integer, SkillStats> skillStats;

	public SkillDataLoader() {
		skillStats = new HashMap<Integer, SkillStats>();
	}

	protected abstract void load(int skillid);

	public abstract boolean loadAll();

	public static SkillDataLoader setInstance(DataFileType wzType, String wzPath) {
		switch (wzType) {
			case KVJ:
				instance = new KvjSkillDataLoader(wzPath);
				break;
		}
		return instance;
	}

	public static SkillDataLoader getInstance() {
		return instance;
	}
}