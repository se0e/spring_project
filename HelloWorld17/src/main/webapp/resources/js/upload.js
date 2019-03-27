/**
 * 
 */

function checkImageType(fileName){
	var pattern= /jpg|gif|png|jpeg/i; // i는 대소문자 구분 안한다는 의미
	return fileName.match(pattern);
}

function getFileInfo(data) { // data= 썸네일에 대한 주소
	var imgsrc, getLink, fileName, fullName; // fullName은 data임.
	
	fullName= data;
	
	if(checkImageType(data)){ // 이미지파일이면
		imgsrc="/displayfile?fileName="+data;

		// 원본파일+파일명 얻어오기
		var prefix=data.substring(0,12);
		var suffix=data.substring(14);

		getLink="/displayfile?fileName="+(prefix+suffix); // 원본파일링크
		var idx= data.indexOf("_", 14); // _의 인덱스를 파일명의 s_다음부터=(14번째) 검색해서 찾음
		fileName=data.substring(idx+1); // 파일명을 _를 기준으로 잘라내기. (_를 제외한 온전한 파일명 얻기)
		
	} else { // 이미지파일이 아니면
		imgsrc="/resources/img/gagi.jpg";
		getLink="/displayfile?fileName="+data;
		var idx= data.indexOf("_"); // _의 인덱스를 검색해서 찾는다. 일반파일에는 s_가 안들어가니까 "_"만 찾으면됨.
		fileName=data.substring(idx+1); // 인덱스값 집어넣고 _다음부터 구해와야하니 +1
	}
			// ex) imgsrc:imgsrc = handlebars : var의 변수
	return {imgsrc:imgsrc, getLink:getLink, fullName:fullName, fileName:fileName}; // JSON형태로 handlebars에 넘겨줌
}