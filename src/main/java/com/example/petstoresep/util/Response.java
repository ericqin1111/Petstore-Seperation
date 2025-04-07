package com.example.petstoresep.util;

import lombok.Data;

@Data
public class Response<T> {

        private int status;
        private String statusInfo;
        private T data;

        public Response() {}

        public Response(int status, String statusInfo, T data) {
            this.status = status;
            this.statusInfo = statusInfo;
            this.data = data;
        }

        public static <T> Response<T> success(T data) {
            return new Response<>(0, "success", data);
        }

        public static <T> Response<T> error(int status, String statusInfo) {
            return new Response<>(status, statusInfo, null);
        }



}
