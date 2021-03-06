
module("ALittle", package.seeall)

local ___rawset = rawset
local ___pairs = pairs
local ___ipairs = ipairs
local ___coroutine = coroutine

ConfigSystem = Class(nil, "ALittle.ConfigSystem")

function ConfigSystem:Ctor(file_path)
	___rawset(self, "_file_path", file_path)
	___rawset(self, "_config_map", {})
	local file = self.__class.__element[1]()
	local content = file:Load(self._file_path)
	if content == nil then
		return
	end
	local error, json_content = TCall(json.decode, content)
	if error ~= nil then
		Log("Json Decode failed." .. file_path .. ", " .. error)
		return
	end
	___rawset(self, "_config_map", json_content)
end

function ConfigSystem:GetConfig(key, default)
	local value = self._config_map[key]
	if value == nil then
		return default
	end
	return value
end

function ConfigSystem:GetInt(key, default)
	local value = self:GetConfig(key, default)
	if value == nil then
		value = 0
	end
	return math.floor(tonumber(value))
end

function ConfigSystem:GetDouble(key, default)
	local value = self:GetConfig(key, default)
	if value == nil then
		value = 0
	end
	return tonumber(value)
end

function ConfigSystem:GetString(key, default)
	local value = self:GetConfig(key, default)
	if value == nil then
		value = ""
	end
	return tostring(self:GetConfig(key, default))
end

function ConfigSystem:SetConfig(key, value, not_save)
	self._config_map[key] = value
	if not not_save then
		self:SaveConfig()
	end
end

function ConfigSystem:CoverConfig(msg, save)
	for k, v in ___pairs(msg) do
		self._config_map[k] = v
	end
	if not save then
		self:SaveConfig()
	end
end

function ConfigSystem:SaveConfig()
	local file = self.__class.__element[2]()
	if not file:Save(self._file_path, json.encode(self._config_map)) then
		Log("Save Congig Failed.", self._file_path)
	end
end

NormalConfigSystem = Template(ConfigSystem, "ALittle.ConfigSystem<ALittle.NormalFileLoader, ALittle.NormalFileSaver>", NormalFileLoader, NormalFileSaver);
