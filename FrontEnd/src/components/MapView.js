import React from "react";
import map_view from "./MapView.module.scss";
import { dummy_data } from "./dummy.js";
import { ThumbUp } from "@material-ui/icons";

const MapView = () => {
  const dummy_jsx = dummy_data.map((data, index) => {
    return (
      <li key={index + 1}>
        <div className={map_view.img_wrap}>
          <img src="https://search.pstatic.net/common/?src=http%3A%2F%2Fimgnews.naver.net%2Fimage%2F5097%2F2019%2F06%2F28%2F366370_263680_1341_20190628104013034.JPG&type=sc960_832" />
        </div>
        <div className={map_view.category_wrap}>
          <p className={map_view.name_wrap}>{data.name}</p>
          <p className={map_view.star_wrap}>{data.star}</p>
          <p className={map_view.text_wrap}>{data.text}</p>
        </div>
        <div
          className={map_view.category_thumb}
          onClick={() => {
            alert("기능을 준비중입니다.");
          }}
        >
          <p>{data.good}</p>
          <ThumbUp />
        </div>
      </li>
    );
  });

  return (
    <>
      <div className={map_view.map_section}>
        <div className={map_view.map_area}></div>
        <ul className={map_view.category_area}>{dummy_jsx}</ul>
      </div>
    </>
  );
};

export default MapView;
