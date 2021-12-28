project = "prosanteconnect/psc-maj-ui"

# Labels can be specified for organizational purposes.
labels = { "domaine" = "psc" }

runner {
  enabled = true
  data_source "git" {
    url = "https://github.com/prosanteconnect/psc-maj-ui.git"
    ref = var.datacenter
  }
  poll {
    enabled = true
  }
}

# An application to deploy.
app "prosanteconnect/psc-maj-ui" {

  # Build specifies how an application should be deployed.
  build {
    use "docker" {
      dockerfile = "${path.app}/${var.dockerfile_path}"
    }

    registry {
      use "docker" {
        image = "${var.registry_path}/psc-maj-ui"
        tag   = gitrefpretty()
        encoded_auth = filebase64("/secrets/dockerAuth.json")
      }
    }
  }

  # Deploy to Nomad
  deploy {
    use "nomad-jobspec" {
      jobspec = templatefile("${path.app}/psc-maj-ui.nomad.tpl", {
        datacenter = var.datacenter
        proxy_host = var.proxy_host
        proxy_port = var.proxy_port
        non_proxy_hosts = var.non_proxy_hosts
        registry_path = var.registry_path
      })
    }
  }
}

variable "datacenter" {
  type    = string
  default = "dc1"
}

variable "dockerfile_path" {
  type = string
  default = "Dockerfile"
}

variable "registry_path" {
  type = string
  default = "registry.repo.proxy-dev-forge.asip.hst.fluxus.net/prosanteconnect"
}

variable "proxy_host" {
  type = string
  default = ""
}

variable "proxy_port" {
  type = string
  default = ""
}

variable "non_proxy_hosts" {
  type = string
  default = "10.0.0.0/8"
}
