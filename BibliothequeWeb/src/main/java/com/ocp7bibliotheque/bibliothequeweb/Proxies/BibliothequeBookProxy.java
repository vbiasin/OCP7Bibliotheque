package com.ocp7bibliotheque.bibliothequeweb.Proxies;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "BibliothequeBook", url = "localhost:8180")
public interface BibliothequeBookProxy {
}
