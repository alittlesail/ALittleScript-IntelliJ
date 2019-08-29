
module("ALittle", package.seeall)

local ___pairs = pairs
local ___ipairs = ipairs
local ___coroutine = coroutine

local __all_name_reflect = {}
table.setweak(__all_name_reflect, false, true)
local __all_id_reflect = {}
table.setweak(__all_id_reflect, false, true)
function RegReflect(name, info)
	if __all_name_reflect[name] ~= nil then
		Error("RegReflect 反射信息注册失败，名字为" .. name .. "已存在")
		return
	end
	local hash = JSHash(name)
	local old_info = __all_id_reflect[hash]
	if old_info ~= nil then
		Error("RegReflect 名字为" .. name .. "和名字为" .. old_info.name .. "哈希值冲突")
		return
	end
	__all_name_reflect[name] = info
	__all_id_reflect[hash] = info
end

function FindReflectByName(name)
	return __all_name_reflect[name]
end

function FindReflectById(id)
	return __all_id_reflect[id]
end

