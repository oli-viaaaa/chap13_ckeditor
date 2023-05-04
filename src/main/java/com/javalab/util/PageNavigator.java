package com.javalab.util;

/**
 * 페이징 네비게이터 함수
 * 
 * @author stoneis.pe.kr
 * @since 2013.07.10
 */
public class PageNavigator {

	/**
	 * 페이징 네비게이터를 만들어주는 함수
	 * 
	 * @param totalCount   - 총 게시물수
	 * @param listCount    - 한페이지 노출될 게시물수
	 * @param pagePerBlock - 노출될 블록 수 [ 1 2 3 4 5...10 ] 10개
	 * @param pageNum      - 페이지 번호
	 * @return
	 */
	public String getPageNavigator(int totalCount, int listCount, int pagePerBlock, int pageNum) {

		StringBuffer sb = new StringBuffer();

		if (totalCount > 0) { // 총 레코드 수가 하나라도 있어야 페이징
			/*
			 * [총 페이지수] 총게시물 101개이고 한페이지 블럭에 게시물 10개 표시 가정 101 % 10 = 1이므로 총 페이지는 101/10 + 1
			 * 즉, 11이 됨.
			 */
			int totalNumOfPage = (totalCount % listCount == 0) ? totalCount / listCount : totalCount / listCount + 1;

			// 페이지 번호 그룹
			/*
			 * [페이지 번호 그룹] 전체 페이지 그룹이 11개이고 한페이지 블럭에 5개 표시 가정 11 % 10 != 0 이면 페이지 블럭은 2개가 됨.
			 * [1..10]이 1블럭 [11]이 또 한블럭
			 */
			int totalNumOfBlock = (totalNumOfPage % pagePerBlock == 0) ? totalNumOfPage / pagePerBlock
					: totalNumOfPage / pagePerBlock + 1;

			/*
			 * [요청된 페이지가 몇 번째 페이지 그룹에 속하는지] 
			 * 	전체 게시물수가 101개이고 1. 요청된 페이지가 10 이하일 경우 10 %
			 *	10(한페이지 노출 페이지수) = 몫은 0 나머지는 0 10 / 10 = 0 페이지 블럭 즉, [1,2,3,...10] 2. 요청된
			 * 	페이지가 11일 경우 11 % 10 = 몫은 1 나머지는 1 11 / 10 =
			 */
			int currentBlock = (pageNum % pagePerBlock == 0) ? pageNum / pagePerBlock : pageNum / pagePerBlock + 1;

			System.out.println("currentBlock : " + currentBlock);

			// 시작페이지와 끝페이지(한 페이지 블럭 내에서)
			// 페이지 블럭에서 시작 페이지
			int startPage = (currentBlock - 1) * pagePerBlock + 1;
			// 페이지 블럭에서 끝 페이지
			int endPage = startPage + pagePerBlock - 1;

			if (endPage > totalNumOfPage)
				endPage = totalNumOfPage;

			// 다음/이전으로 갈 것이 있는지 확인 있다면 아이콘 표시 없다면 아이콘 없음.
			boolean isNext = false;
			boolean isPrev = false;

			// 현재 페이지가 토털 블럭 보다 작을 때만 >> 보여줌(총 페이지 블럭이 3인데 내가 현재 있는 페이지 블럭이 3이면 >> 안나와야)
			if (currentBlock < totalNumOfBlock)
				isNext = true;

			if (currentBlock > 1)
				isPrev = true;
			if (totalNumOfBlock == 1) {
				isNext = false;
				isPrev = false;
			}
			// 요청페이지가 1보다 크면 << 표시
			if (pageNum > 1) { // 쿼리스트링에서 & = &amp;
				sb.append("<a href=\"").append("boardList?pageNum=1");
				sb.append("\" title=\"<<\"><<</a>&nbsp;");
			}
			if (isPrev) { // << 가 있으면
				int goPrevPage = startPage - pagePerBlock;
				sb.append("&nbsp;&nbsp;<a href=\"").append("boardList?pageNum=" + goPrevPage + "");
				sb.append("\" title=\"<\"><</a>");
			} else {

			}
			for (int i = startPage; i <= endPage; i++) {
				if (i == pageNum) {
					sb.append("<a href=\"#\"><strong>").append(i).append("</strong></a>&nbsp;&nbsp;");
				} else {
					sb.append("<a href=\"").append("boardList?pageNum=" + i);
					sb.append("\" title=\"" + i + "\">").append(i).append("</a>&nbsp;&nbsp;");
				}
			}
			if (isNext) {
				int goNextPage = startPage + pagePerBlock;

				sb.append("<a href=\"").append("boardList?pageNum=" + goNextPage);
				sb.append("\" title=\">\">></a>");
			} else {

			}
			if (totalNumOfPage > pageNum) {
				sb.append("&nbsp;&nbsp;<a href=\"").append("boardList?pageNum=" + totalNumOfPage);
				sb.append("\" title=\">>\">>></a>");
			}
		}

		return sb.toString();
	}
}
