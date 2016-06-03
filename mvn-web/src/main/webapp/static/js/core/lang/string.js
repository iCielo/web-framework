/**
 * 统计字节数，汉字占2个字节
 * 
 * @author cielo 2012-11-19
 * @return
 */
String.prototype.lengthOfByte = function() {
	return this.replace(/[^\x00-\xff]/g, "**").length;
};

/**
 * 以字节数截取字符串，若最后一个是双字节则舍弃
 * 
 * @param start
 *            起始字节
 * @param length
 *            字节长度
 * @author cielo 2012-11-23
 */
String.prototype.substrOfByte = function(start, length) {
	var num = 0;// 字节数
	var realLength = 0;// 实际应截取的字符长度
	for (var i = start; i < this.length; i = i + 1) {
		var c = this.charAt(i);
		if (/[^\x00-\xff]/.test(c)) {// 若是双字节
			num = num + 2;
		} else {// 若是单字节
			num = num + 1;
		}
		if (num <= length) {
			realLength = realLength + 1;// 累加一个字符的长度
		} else {
			break;
		}
	}
	return this.substr(start, realLength);
};

/**
 * 去除字符串的前后空字符
 * 
 * @return
 */
String.prototype.trim = function() {
	return this.replace(/(^[\s\xA0]+|[\s\xA0]+$)/g, '');
};

/**
 * 字符串替换全部
 * 
 * @param s1
 * @param s2
 * @return
 */
String.prototype.replaceAll = function(s1, s2) {
	return this.replace(new RegExp(s1, "gm"), s2);
};

/**
 * 判断字符串是否是以str为开头的
 * 
 * @param str
 * @return
 */
String.prototype.startWith = function(str) {
	if (str == null || str == "" || this.length == 0 || str.length > this.length)
		return false;
	if (this.substr(0, str.length) == str)
		return true;
	else
		return false;
	return true;
};

/**
 * 首字母大写
 * 
 * @returns
 */
String.prototype.firstUpperCase = function() {
	return this.substring(0, 1).toUpperCase() + this.substring(1);
};

/**
 * 首字母小写
 * 
 * @returns
 */
String.prototype.firstLowerCase = function() {
	return this.substring(0, 1).toLowerCase() + this.substring(1);
};